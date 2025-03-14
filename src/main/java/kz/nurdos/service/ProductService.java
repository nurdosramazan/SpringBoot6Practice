package kz.nurdos.service;

import kz.nurdos.dto.ProductAddForm;
import kz.nurdos.dto.EntityMapper;
import kz.nurdos.dto.ProductUpdateInfoForm;
import kz.nurdos.model.Product;
import kz.nurdos.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product id " + id + " not found"));
    }

    public void addProduct(ProductAddForm productForm) {
        Product product = EntityMapper.toProduct(productForm);
        productRepository.save(product);
    }

    public void updateProductInfo(Long id, ProductUpdateInfoForm productForm) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product id " + id + " not found"));
        product.setDescription();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
