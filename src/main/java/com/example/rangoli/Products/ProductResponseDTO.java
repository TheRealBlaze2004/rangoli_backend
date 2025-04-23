package com.example.rangoli.Products;

import java.util.List;

public class ProductResponseDTO {
    private int productID;
    private String productname;
    private String imgurl;
    private String productprice;
    private List<String> categorynames;

    public ProductResponseDTO(int productID, String productname, String imgurl, String productprice, List<String> categorynames) {
        this.productID = productID;
        this.productname = productname;
        this.imgurl = imgurl;
        this.productprice = productprice;
        this.categorynames = categorynames;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }

    public List<String> getCategorynames() {
        return categorynames;
    }

    public void setCategorynames(List<String> categorynames) {
        this.categorynames = categorynames;
    }
}
