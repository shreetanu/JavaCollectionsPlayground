package my.practice.datastructures.shopping.Decorators;

import my.practice.datastructures.shopping.Product.Product;

public class CouponDecorator extends ProductDecorator {

    public CouponDecorator(Product product) {
        super(product);
    }

    @Override
    public double getPrice() {
        if(product.getPrice() >= 500)
            return product.getPrice() - 100;
        return product.getPrice();
    }
}
