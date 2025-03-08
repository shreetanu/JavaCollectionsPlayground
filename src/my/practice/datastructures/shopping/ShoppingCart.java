package my.practice.datastructures.shopping;

import my.practice.datastructures.shopping.Decorators.CouponDecorator;
import my.practice.datastructures.shopping.Decorators.PercentageDecorator;
import my.practice.datastructures.shopping.Product.Item;
import my.practice.datastructures.shopping.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> itemsInCart;

    public ShoppingCart() {
        itemsInCart = new ArrayList<>();
    }

    public void addItems(Product product) {
        product = new CouponDecorator(new PercentageDecorator(product));
        itemsInCart.add(product);
    }

    public void displayTotal() {
        double total = 0;
        for(Product product: itemsInCart) {
            total+= product.getPrice();
        }
        System.out.println("TOTAL IS "+total);
    }

    public static void main(String[] args) {
        Product fruit1 = new Item("BANANA", 20, ProductType.FRUITS);
        Product fruit2 = new Item("APPLE",700,ProductType.FRUITS);
        Product earphones = new Item("EARPHONES",900,ProductType.ELECTRONICS);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItems(fruit1);
        shoppingCart.addItems(fruit2);
        shoppingCart.addItems(earphones);

        shoppingCart.displayTotal();
    }

}
