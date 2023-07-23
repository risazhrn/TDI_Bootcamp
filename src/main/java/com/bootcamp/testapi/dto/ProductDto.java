package com.bootcamp.testapi.dto;

import lombok.Data;

public class ProductDto {
    @Data
    public static class Save{
        private String name;
        private Integer category_id;
        private Integer stock;
    }
}
