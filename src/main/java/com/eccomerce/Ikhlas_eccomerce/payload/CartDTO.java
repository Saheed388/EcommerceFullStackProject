package com.eccomerce.Ikhlas_eccomerce.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    private Integer cartId;
    private Double totalPrice = 0.0;

    private List<ProductDTO> products = new ArrayList<>();


}
