package com.foodplus.foodplus.Model;

public class Product {

    private String name;
    private String product_image;
    private int price;


    public Product(String name, String product_image, int price) {
        this.name = name;
        this.product_image = product_image;
        this.price = price;

    }

    //    Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //   Product_image
    public String getProductImage() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    //    Price
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
