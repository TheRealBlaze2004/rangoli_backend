package com.example.rangoli.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Products> products = productRepository.findAll();

        return products.stream().map(product -> {
            List<String> categorynames = product.getProductCategories().stream()
                    .map(pc -> pc.getCategories().getCategoryname())
                    .collect(Collectors.toList());

            return new ProductResponseDTO(
                    product.getProductID(),
                    product.getProductname(),
                    product.getImgurl(),
                    product.getProductprice(),
                    categorynames
            );
        }).collect(Collectors.toList());
    }
    public List<ProductResponseDTO> getProductsByCategory(String categoryname) {
        List<Products> products = productRepository.findAll();

        return products.stream()
                .filter(product -> product.getProductCategories().stream()
                        .anyMatch(pc -> pc.getCategories().getCategoryname().equalsIgnoreCase(categoryname)))
                .map(product -> {
                    List<String> categorynames = product.getProductCategories().stream()
                            .map(pc -> pc.getCategories().getCategoryname())
                            .collect(Collectors.toList());
                    return new ProductResponseDTO(
                            product.getProductID(),
                            product.getProductname(),
                            product.getImgurl(),
                            product.getProductprice(),
                            categorynames
                    );
                })
                .collect(Collectors.toList());
    }
}