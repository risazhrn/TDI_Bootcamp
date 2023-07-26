package com.bootcamp.testapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class CategoryDto {
    @Data
    public static class Save{
        @NotNull(message = "Nama tidak boleh null")
        @NotEmpty(message = "Nama tidak boleh kosong")
        private String name;
    }

    @Data
    public static class Update{
        @NotNull(message = "Nama tidak boleh null")
        @NotEmpty(message = "Nama tidak boleh kosong")
        private String name;
    }
}
