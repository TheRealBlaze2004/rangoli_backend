package com.example.rangoli.Products;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity

public class Product_Categories {
    @EmbeddedId
    private ProductCategoriesKey id;

    @ManyToOne
    @MapsId("productID")
    @JoinColumn(name="productID")
    @JsonBackReference
    private Products products;


    @ManyToOne
    @MapsId("categoryID")
    @JoinColumn(name="categoryID")
    @JsonBackReference
    private Categories categories;

    public int getProductID(){
        return products!=null?products.getProductID():0;
    }

    public void setProductID(int productID){
        this.products=new Products();
        this.products.setProductID(productID);
    }

    public int getCategoryID(){
        return categories!=null?categories.getCategoryID():0;
    }

    public void setCategoryID(int categoryID){
        this.categories=new Categories();
        this.categories.setCategoryID(categoryID);
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
}
