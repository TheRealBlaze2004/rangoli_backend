package com.example.rangoli.Products;

import com.example.rangoli.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public void addToCart(int userId,int productId,int quantity){
        Cartitems exist=cartRepository.findByUserIdAndProductId(userId,productId);
        if(exist!=null){
            cartRepository.updateQuantity(userId,productId,quantity);
        }else{
            Cartitems newItem=new Cartitems();
            newItem.setQuantity(quantity);
            newItem.setUser(userRepository.findById(userId).orElseThrow());
            newItem.setProduct(productRepository.findById(productId).orElseThrow());
            cartRepository.save(newItem);
        }
    }
}
