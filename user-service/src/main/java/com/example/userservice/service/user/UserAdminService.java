package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.PageDTO;
import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.user.api.IUserAdminService;
import com.example.userservice.utils.exceptions.errors.MailAlreadyExistException;
import com.example.userservice.utils.exceptions.errors.UserAlreadyUpdatedException;
import com.example.userservice.utils.exceptions.errors.UserNotFoundException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class UserAdminService implements IUserAdminService {

    private final IUserRepository userRepository;
    private final Converter<UserEntity, UserDTO> toDtoConverter;
    private final PasswordEncoder passwordEncoder;



   public UserAdminService(IUserRepository userRepository,
                            Converter<UserEntity, UserDTO> toDtoConverter,
                            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.toDtoConverter = toDtoConverter;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createUser(UserEntity newUser) {
        if (!this.userRepository.existsByMail(newUser.getMail())) {
            assert newUser != null;
            newUser.setPassword(this.passwordEncoder.encode(newUser.getPassword()));
            this.userRepository.save(newUser);
        } else {
            throw
                    new MailAlreadyExistException("This e-mail is already exist");
        }
    }

    @Override
    public PageDTO<UserDTO> getUserPage(Pageable pageable) {
        Page<UserEntity> userEntityPage = this.userRepository.findAllPage(pageable);
        List<UserDTO> users = new ArrayList<>();

        for (UserEntity userEntity : this.userRepository.findAll()){
            users.add(this.toDtoConverter.convert(userEntity));
        }

        return new PageDTO<>(
                userEntityPage.getNumber(),
                userEntityPage.getSize(),
                userEntityPage.getTotalPages(),
                userEntityPage.getTotalElements(),
                userEntityPage.isFirst(),
                userEntityPage.getNumberOfElements(),
                userEntityPage.isLast(),
                users);
    }

    @Override
    public UserDTO getUserInfo(UUID uuid) {

        UserEntity userInfo = this.userRepository.findById(uuid)
                .orElseThrow(() -> new UserNotFoundException("User with uuid " + uuid + " was not found"));
        return this.toDtoConverter.convert(userInfo);
    }

    @Override
    public void updateUser(UUID id, Timestamp dt_update, UserAdminDTO user) {
        UserEntity userUpdate = this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with uuid " + id + " was not found"));

        if (user.getMail().equals(this.userRepository.findByMail(user.getMail()))
             && !id.equals(this.userRepository.findById(id))) {

            throw new MailAlreadyExistException("This e-mail is already exist");

        } else {
            if (Timestamp.valueOf(userUpdate.getDt_update()).equals(dt_update)) {
                updatingUser(user, userUpdate);
            }
            else {
                throw new UserAlreadyUpdatedException("This user was updated");
            }
        }
    }

    private void updatingUser(UserAdminDTO user, UserEntity userUpdate) {
        userUpdate.setMail(user.getMail());
        userUpdate.setDt_update(LocalDateTime.now());
        userUpdate.setRole(user.getRole());
        userUpdate.setStatus(user.getStatus());
        userUpdate.setFio(user.getFio());
        userUpdate.setPassword(user.getPassword());
        this.userRepository.save(userUpdate);
    }


}
