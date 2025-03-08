package my.practice.datastructures.shopping.Decorators;

import my.practice.datastructures.shopping.Product.Product;
import my.practice.datastructures.shopping.ProductType;

public abstract class ProductDecorator implements Product {
    protected Product product;

    public ProductDecorator(Product product) {
        this.product = product;
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }
}
