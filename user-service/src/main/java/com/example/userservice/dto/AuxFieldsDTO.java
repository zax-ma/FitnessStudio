package com.example.userservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.UUID;

public class AuxFieldsDTO {


    private UUID uuid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dt_create;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dt_update;


    public AuxFieldsDTO() {
        this.uuid = UUID.randomUUID();
        this.dt_create = LocalDateTime.now();
        this.dt_update = LocalDateTime.now();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = UUID.randomUUID();
    }

    public LocalDateTime getDt_create() {
        return dt_create;
    }

    public void setDt_create(LocalDateTime dt_create) {
        this.dt_create = LocalDateTime.now();
    }

    public LocalDateTime getDt_update() {
        return dt_update;
    }

    public void setDt_update(LocalDateTime dt_update) {
        this.dt_update = LocalDateTime.now();
    }
}
