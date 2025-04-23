package com.example.rangoli.Products;

import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {
    ProductRepository productRepository;
    ProductService productService;
    @Autowired
    public ProductController(ProductRepository productRepository, ProductService productService){
        this.productRepository=productRepository;
        this.productService=productService;
    }
    @GetMapping("/products")
    @PermitAll
    public List<Products> getAllProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/product/categories")
    public ResponseEntity<List<ProductResponseDTO>> getProductCatergory(@RequestParam String categoryname){
        List<ProductResponseDTO> prodCategory=productService.getProductsByCategory(categoryname);
        return ResponseEntity.ok(prodCategory);
    }
}
