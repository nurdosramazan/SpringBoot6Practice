package kz.nurdos.controller;

import kz.nurdos.model.Product;
import kz.nurdos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
    }
}
