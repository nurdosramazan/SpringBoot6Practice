package kz.nurdos.dto;

import kz.nurdos.model.Product;

public class EntityMapper {
    public static Product toProduct(ProductCreateForm productForm) {
        return Product.builder()
                .name(productForm.getName())
                .description(productForm.getDescription())
                .price(productForm.getPrice())
                .category(productForm.getCategory())
                .quantity(productForm.getQuantity())
                .available(true)
                .build();
    }
}