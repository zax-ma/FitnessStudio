package com.example.userservice.dto;

public class UserAdminDTO {
    private String mail;
    private String fio;
    private UserRole role;
    private UserStatus status;
    private String password;
    public UserAdminDTO(){
    }

    public String getMail() {
        return mail;
    }

    public String getFio() {
        return fio;
    }

    public UserRole getRole() {
        return role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public static AdminBuilder create() {
        return new UserAdminDTO().new AdminBuilder();
    }
    public class AdminBuilder{
        public AdminBuilder(){
        }

        public AdminBuilder setFio(String fio) {
            UserAdminDTO.this.fio = fio;
            return this;
        }
        public AdminBuilder setMail(String mail) {
            UserAdminDTO.this.mail = mail;
            return this;
        }
        public AdminBuilder setRole(UserRole role) {
            UserAdminDTO.this.role = role;
            return this;
        }
        public AdminBuilder setStatus(UserStatus status) {
            UserAdminDTO.this.status = status;
            return this;
        }
        public AdminBuilder setPassword(String password) {
            UserAdminDTO.this.password = password;
            return this;
        }

        public UserAdminDTO build() {
            return UserAdminDTO.this;
        }

        @Override
        public String toString() {
            return "AdminUserBuilder{" +
                    "mail='" + mail + '\'' +
                    ", fio='" + fio + '\'' +
                    ", role=" + role +
                    ", status=" + status +
                    ", password='" + password + '\'' +
                    '}';
        }



    }

    @Override
    public String toString() {
        return "UserAdminDto{" +
                "mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", password='" + password + '\'' +
                '}';
    }
}
