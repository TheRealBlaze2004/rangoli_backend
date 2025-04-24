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
    CartService cartService;
    CartRepository cartRepository;
    @Autowired
    public ProductController(ProductRepository productRepository, ProductService productService, CartService cartService,CartRepository cartRepository){
        this.productRepository=productRepository;
        this.productService=productService;
        this.cartService=cartService;
        this.cartRepository=cartRepository;
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
    @PostMapping("/addcart")
    public ResponseEntity<?> addToCart(@RequestParam CartItemRequest request){
        int userId = request.user_id;
        int productId = request.product_id;
        int quantity = request.quantity;

        Cartitems existingItem = cartRepository.findByUserIdAndProductId(userId, productId);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            cartRepository.save(existingItem);
            return ResponseEntity.ok("Cart item quantity updated");
        } else {
            Cartitems newItem = new Cartitems();
            newItem.setUser_id(userId);
            newItem.setProduct_id(productId);
            newItem.setQuantity(quantity);
            cartRepository.save(newItem);
            return ResponseEntity.ok("Item added to cart");
        }
    }

    @GetMapping("/cart")
    public ResponseEntity<List<CartItemResponse>> getCartItems(@RequestParam int userId) {
        List<CartItemResponse> cartItems = cartRepository.getCartItems(userId);
        return ResponseEntity.ok(cartItems);
    }
}
