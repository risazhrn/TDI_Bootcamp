package com.bootcamp.testapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class UsersDto {
    @Data
    public static class Save{
        @NotEmpty(message = "gaboleh string kosong")
        @NotNull(message = "gaboleh null")
        private String name;

        @Email
        private String email;

        @Size(min = 11, max = 13)
        private String phone;
    }

}
