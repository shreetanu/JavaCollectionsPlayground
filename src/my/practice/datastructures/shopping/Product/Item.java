package my.practice.datastructures.shopping.Product;

import my.practice.datastructures.shopping.ProductType;

public class Item implements Product{
    String name;
    double price;
    ProductType productType;

    public Item(String name,double price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
