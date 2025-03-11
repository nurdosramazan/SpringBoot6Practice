package kz.nurdos.service;

import kz.nurdos.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(new Product(101, "Iphone", 50000), new Product(102, "Canon Camera", 70000), new Product(103, "Shure Mic", 10000)));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int productId) {
        return products.stream().filter(p -> p.getProductId() == productId).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product id " + productId + " not found"));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < products.size(); i++)
            if (products.get(i).getProductId() == product.getProductId()) {
                index = i;
                found = true;
            }
        if (!found) throw new NoSuchElementException("Product id " + product.getProductId() + " not found");
        products.set(index, product);
    }

    public void deleteProduct(int productId) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < products.size(); i++)
            if (products.get(i).getProductId() == productId) {
                index = i;
                found = true;
            }
        if (!found) throw new NoSuchElementException("Product id " + productId + " not found");
        products.remove(index);
    }
}
