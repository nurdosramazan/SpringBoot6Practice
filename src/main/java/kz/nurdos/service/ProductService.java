package kz.nurdos.service;

import jakarta.transaction.Transactional;
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
        System.out.println("Calling findAll() for product");
        return productRepository.findAllByOrderByIdAsc();
    }

    public Product getProductById(Long id) {
        System.out.println("Calling findById() for product");
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product id " + id + " not found"));
    }

    @Transactional
    public void addProduct(ProductAddForm productForm) {
        Product product = EntityMapper.toProduct(productForm);
        System.out.println("Calling save() for product");
        productRepository.save(product);
    }

    @Transactional
    public void updateProductInfo(Long id, ProductUpdateInfoForm productForm) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product id " + id + " not found"));

        if (productForm.getDescription() != null) product.setDescription(productForm.getDescription());
        if (productForm.getPrice() != null) product.setPrice(productForm.getPrice());
        if (productForm.getCategory() != null) product.setCategory(productForm.getCategory());
        if (productForm.getQuantity() != null) product.setQuantity(productForm.getQuantity());

        System.out.println("Calling save() for product");
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        System.out.println("Calling deleteById() for product");
        productRepository.deleteById(id);
    }
}
