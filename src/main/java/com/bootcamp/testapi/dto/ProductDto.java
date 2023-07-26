package com.bootcamp.testapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class ProductDto {
    @Data
    public static class Save{
        @NotEmpty(message = "gaboleh string kosong")
        @NotNull(message = "gaboleh null")
        private String name;

        @Min(0)
        @NotNull(message = "gaboleh kosong")
        private Integer category_id;

        @Min(0)
        private Integer stock;
    }

    @Data
    public static class Update{
        @NotEmpty(message = "gaboleh string kosong")
        @NotNull(message = "gaboleh null")
        private String name;

        @Min(0)
        @NotNull(message = "gaboleh kosong")
        private Integer category_id;

        @Min(0)
        private Integer stock;
    }
}
