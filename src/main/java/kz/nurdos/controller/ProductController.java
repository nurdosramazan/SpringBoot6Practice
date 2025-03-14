package kz.nurdos.controller;

import jakarta.validation.Valid;
import kz.nurdos.dto.ProductAddForm;
import kz.nurdos.dto.ProductUpdateInfoForm;
import kz.nurdos.exception.FormValidationException;
import kz.nurdos.model.Product;
import kz.nurdos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@Valid @RequestBody ProductAddForm productForm,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) throw new FormValidationException(bindingResult);

        productService.addProduct(productForm);
        return ResponseEntity.status(HttpStatus.CREATED).body("The product was successfully added.");
    }

//    @PatchMapping
//    public ResponseEntity<String> updateProductName()

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateProductInfo(@PathVariable Long id,
                                                @Valid @RequestBody ProductUpdateInfoForm productForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) throw new FormValidationException(bindingResult);

        productService.updateProductInfo(id, productForm);
        return ResponseEntity.status(HttpStatus.OK).body("The product was successfully updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("The product was successfully deleted.");
    }
}
