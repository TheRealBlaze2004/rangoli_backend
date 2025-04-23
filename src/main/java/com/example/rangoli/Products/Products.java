package com.example.rangoli.Products;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Products {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int productID;
    private String productname;
    private String imgurl;
    private String productprice;
    @OneToMany(mappedBy = "products")
    @JsonManagedReference
    private List<Product_Categories> productCategories;

    public int getProductID(){return productID;}
    public void setProductID(int productID){this.productID=productID;}

    public String getProductname(){return productname;}
    public void setProductname(String productname){this.productname=productname;}

    public String getImgurl(){return imgurl;}
    public void setImgurl(String imgurl){this.imgurl=imgurl;}

    public String getProductprice(){return productprice;}
    public void setProductprice(String productprice){this.productprice=productprice;}

    public List<Product_Categories> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<Product_Categories> productCategories) {
        this.productCategories = productCategories;
    }
}
