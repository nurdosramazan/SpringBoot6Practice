package kz.nurdos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

//@JsonInclude(JsonInclude.Include.NON_NULL) what is this
@Getter
public class ProductUpdateInfoForm {
    @Length(max = 500, message = "Maximum description text exceeded")
    private String description;

    @PositiveOrZero(message = "Provided price is unacceptable")
    private Double price;

    @Length(max = 30, message = "Category length is unacceptable")
    private String category;

    @PositiveOrZero(message = "Provided quantity is unacceptable")
    private Integer quantity;
}
