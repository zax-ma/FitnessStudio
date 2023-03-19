package com.example.userservice.service.code.api;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.entity.VerificationCodeEntity;

public interface IVerificationCodeService {

    void createCode(UserEntity user);

    VerificationCodeEntity getCode(String code);

}
