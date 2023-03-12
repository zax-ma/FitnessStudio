package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.PageDTO;
import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.api.IUserAdminService;
import com.example.userservice.utils.exceptions.SingleErrorResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class UserAdminService implements IUserAdminService {

    private IUserRepository userRepository;
    private Converter<UserAdminDTO, UserEntity> toEntityConverter;
    private Converter<UserEntity, UserDTO> toDtoConverter;
 //   private PasswordEncoder passwordEncoder;

    public UserAdminService(IUserRepository userRepository,
                            Converter<UserAdminDTO, UserEntity> toEntityConverter,
                            Converter<UserEntity, UserDTO> toDtoConverter) {
        this.userRepository = userRepository;
        this.toEntityConverter = toEntityConverter;
        this.toDtoConverter = toDtoConverter;

    }

/*    public UserAdminService(IUserRepository userRepository,
                            Converter<UserAdminDTO, UserEntity> toEntityConverter,
                            Converter<UserEntity, UserDTO> toDtoConverter,
                            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.toEntityConverter = toEntityConverter;
        this.toDtoConverter = toDtoConverter;
        this.passwordEncoder = passwordEncoder;
    }*/

    @Override
    public void createUser(UserAdminDTO userAdminDto) {
        if (!userRepository.existsByMail(userAdminDto.getMail())) {
            UserEntity newUser = this.toEntityConverter.convert(userAdminDto);
            assert newUser != null;
            newUser.setPassword(userAdminDto.getPassword()); //newUser.setPassword(passwordEncoder.encode(userAdminDto.getPassword()));
            this.userRepository.save(newUser);
        } else {
            throw
                    new NoSuchElementException("Email is already registered");
        }
    }

    @Override
    public PageDTO<UserDTO> getUserPage(int page, int size) {
        Page<UserEntity> userEntityPage = userRepository.findAll(PageRequest.of(page, size));
        List<UserDTO> users = new ArrayList<>();

        for (UserEntity userEntity : userRepository.findAll()){
            users.add(toDtoConverter.convert(userEntity));
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
                .orElseThrow(() -> new SingleErrorResponse("User with uuid " + uuid + " was not found"));
        return this.toDtoConverter.convert(userInfo);
    }

    @Override
    public void updateUser(UUID uuid, Timestamp lst_update, UserAdminDTO user) {
        UserEntity userUpdate = this.userRepository.findById(uuid)
                .orElseThrow(() -> new SingleErrorResponse("User with uuid " + uuid + " was not found"));

        if (user.getMail().equals(this.userRepository.findByMail(user.getMail()))
             && !uuid.equals(this.userRepository.findById(uuid))) {

            throw new SingleErrorResponse("This e-mail is already exist");

        } else {
            if (Timestamp.valueOf(userUpdate.getDt_update()).equals(lst_update)) {
                userUpdate.setMail(user.getMail());
                userUpdate.setDt_update(LocalDateTime.now());
                userUpdate.setRole(user.getRole());
                userUpdate.setStatus(user.getStatus());
                userUpdate.setFio(user.getFio());
                userUpdate.setPassword(user.getPassword());
                userRepository.save(userUpdate);
            }
            else {
                throw new SingleErrorResponse("This user was already updated");
            }
        }
    }


}
