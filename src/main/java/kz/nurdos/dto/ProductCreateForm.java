package kz.nurdos.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class ProductCreateForm {
    @Length(min = 2, max = 50, message = "Name length is unacceptable.")
    private String name;

    @Length(max = 500, message = "Maximum description text exceeded")
    private String description;

    @PositiveOrZero(message = "Price is unacceptable")
    private Double price;

    @Length(max = 30, message = "Category length is unacceptable")
    private String category;

    @PositiveOrZero(message = "Quantity is unacceptable")
    private Integer quantity;
}
