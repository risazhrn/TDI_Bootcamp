package com.bootcamp.testapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class CategoryDto {
    @Data
    public static class Save{
        @NotEmpty(message = "gaboleh string kosong")
        @NotNull(message = "gaboleh null")
        private String name;
    }
}
