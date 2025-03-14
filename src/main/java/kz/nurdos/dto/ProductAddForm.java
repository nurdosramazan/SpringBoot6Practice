package kz.nurdos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

//TODO: nonrelated fields in json request are accepted(jsonignore?)
@Getter
public class ProductAddForm {
    @NotNull(message = "Name must be specified")
    @Length(min = 2, max = 50, message = "Name length is unacceptable.")
    private String name;

    @Length(max = 500, message = "Maximum description text exceeded")
    private String description;

    @NotNull(message = "Price must be specified")
    @PositiveOrZero(message = "Provided price is unacceptable")
    private Double price;

    @NotNull(message = "Category must be specified")
    @Length(max = 30, message = "Category length is unacceptable")
    private String category;

    @NotNull(message = "Quantity must be specified")
    @PositiveOrZero(message = "Provided quantity is unacceptable")
    private Integer quantity;
}
