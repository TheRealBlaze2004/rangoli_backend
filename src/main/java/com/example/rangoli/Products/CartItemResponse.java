package com.example.rangoli.Products;

public class CartItemResponse {
    public int cart_id;
    public int user_id;
    public int quantity;
    public int product_id;
    public String product_name;
    public String productprice;
    public String imgurl;

    // Constructor
    public CartItemResponse(int cart_id, int user_id, int quantity, int product_id, String product_name, String productprice, String imgurl) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.quantity = quantity;
        this.product_id = product_id;
        this.product_name = product_name;
        this.productprice = productprice;
        this.imgurl = imgurl;
    }
}
