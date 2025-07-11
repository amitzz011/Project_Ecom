package com.batchten.ecom.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int id;

    private String name;

    private String brand;

    private String description;

    private BigDecimal price;

    private String category;

    private Date releaseDate;

    private boolean productAvailable;

    private int quantity;
}
