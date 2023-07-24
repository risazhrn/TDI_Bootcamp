package com.bootcamp.testapi.dto;

import lombok.Data;

public class UserProductDto {
    @Data
    public static class Save {
        private Integer user_id;
        private Integer product_id;
        private Integer quantity;
    }
}
