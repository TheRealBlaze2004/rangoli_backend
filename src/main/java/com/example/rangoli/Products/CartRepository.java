package com.example.rangoli.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartRepository extends JpaRepository<Cartitems,Integer> {
    @Query(value = "SELECT c.cart_id,c.user_id,c.quantity,p.productID AS product_id,p.productname AS product_name,p.productprice,p.imgurl FROM cart_items c JOIN products p ON c.product_id = p.productID WHERE c.user_id = :userID;",nativeQuery = true)
    public List<CartItemResponse> getCartItems(@Param("userID")int userID);

    @Query("SELECT c FROM Cartitems c WHERE c.user.id = :userId AND c.product.productID = :productId")
    Cartitems findByUserIdAndProductId(@Param(value = "userId")int userId, @Param("productId") int productId);


    @Modifying
    @Transactional
    @Query("UPDATE Cartitems c SET c.quantity = c.quantity + :qty WHERE c.user.id = :userId AND c.product.productID = :productId")
    void updateQuantity(int userId, int productId, int qty);
}
