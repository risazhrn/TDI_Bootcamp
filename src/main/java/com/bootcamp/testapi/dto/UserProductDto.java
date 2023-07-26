package com.bootcamp.testapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class UserProductDto {
    @Data
    public static class Save {
        @NotNull(message = "gaboleh null")
        private Integer user_id;

        @NotNull(message = "gaboleh null")
        private Integer product_id;

        @Min(1)
        private Integer quantity;
    }

    @Data
    public static class Update {
        @NotNull(message = "gaboleh null")
        private Integer user_id;

        @NotNull(message = "gaboleh null")
        private Integer product_id;

        @Min(1)
        private Integer quantity;
    }
}
