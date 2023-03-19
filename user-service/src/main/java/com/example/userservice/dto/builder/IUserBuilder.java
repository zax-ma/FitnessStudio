package com.example.userservice.dto.builder;

public interface IUserBuilder {
    void buildMail();
    void buildFio();
    void buildPassword();
    void buildRole();
    void buildStatus();
    void buildDtCreate();
    void buildDtUpdate();
}
