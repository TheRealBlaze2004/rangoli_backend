package com.example.rangoli.Products;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryID;
    private String categoryname;
    @OneToMany(mappedBy = "categories")
    @JsonManagedReference
    private List<Product_Categories> productCategories;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public List<Product_Categories> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<Product_Categories> productCategories) {
        this.productCategories = productCategories;
    }
}
