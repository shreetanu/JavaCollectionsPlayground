package my.practice.datastructures.shopping.Decorators;

import my.practice.datastructures.shopping.Product.Product;

public class PercentageDecorator extends ProductDecorator{

    public PercentageDecorator(Product product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return product.getPrice() - product.getPrice()*0.1;
    }
}
