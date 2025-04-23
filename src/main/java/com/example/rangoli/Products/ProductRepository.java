package com.example.rangoli.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,Integer> {
    Products findByproductname(String productname);
    @Query(value = "SELECT p.* FROM products p JOIN product_categories pc ON p.productID = pc.productID JOIN categories c ON pc.categoryID = c.categoryID WHERE c.categoryname= :categoryname",
    nativeQuery = true)
    List<Products> findByCategory(@Param("categoryname")String categoryname);
}
