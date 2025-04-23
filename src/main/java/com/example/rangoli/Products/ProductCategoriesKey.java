package com.example.rangoli.Products;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class ProductCategoriesKey implements Serializable {
    private int productID;
    private int categoryID;

    public ProductCategoriesKey(){}

    public ProductCategoriesKey(int productID, int categoryID){
        this.productID=productID;
        this.categoryID=categoryID;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof ProductCategoriesKey)) return false;
        ProductCategoriesKey that=(ProductCategoriesKey) o;
        return productID==that.productID &&
                categoryID==that.categoryID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, categoryID);
    }
}
