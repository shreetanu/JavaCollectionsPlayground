package my.practice.datastructures.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Item {
    String itemName;
    double itemPrice;
    public Item(String itemName,double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
/**
 * This class is built for the purpose of the demo of
 * Java Streams with Map<String, Double> and groupingBy
 */
public class ShoppingCart {
    public static void main(String[] args) {
        List<Item> l1 = Arrays.asList(new Item("Apple",89.0),new Item("Apple",56.8),new Item("Batteries",65.2),new Item("Banana", 50.0),new Item("Banana",100.0));

        /**
         * Here we are grouping by just item name,
         * a map is created with the item name along with the list of items
         */
        Map<String,List<Item>> mp = l1.stream().collect(Collectors.groupingBy(item -> item.itemName));

        for(Map.Entry<String,List<Item>> entry: mp.entrySet()) {
            System.out.println("KEY"+entry.getKey());
            for(Item i: entry.getValue())
                System.out.println("VALUE"+i.itemPrice);
        }

        /**
         * Grouping and Counting
         * using groupingBy
         * Here we are grouping and counting how many elements are there in a group
         */
        Map<String,Long> mp1 = l1.stream().collect(Collectors.groupingBy(item -> item.itemName,Collectors.counting()));

        for(Map.Entry<String,Long> entry: mp1.entrySet()) {
            System.out.println("KEY"+entry.getKey());
            System.out.println("VALUE"+entry.getValue());
        }

        /**
         * Example: Grouping by Multiple Properties (Nested Grouping)
         * You can chain multiple groupingBy collectors to perform hierarchical grouping. For example, group items first by category and then by price range.
         */

        Map<String,Map<String,List<Item>>> newMap = l1.stream().collect(Collectors.groupingBy(Item::getItemName,Collectors.groupingBy(
                item -> {
            if(item.getItemPrice() <= 50.0) return "LOW";
            else return "HIGH";
        })));

        for(Map.Entry<String,Map<String,List<Item>>> entry: newMap.entrySet()) {
            System.out.println("KEY    ****"+entry.getKey());
           for(Map.Entry<String,List<Item>> en: entry.getValue().entrySet()) {
               System.out.println("KEY         *******"+en.getKey());
               for(Item i1: en.getValue()) {
                   System.out.println(i1.getItemPrice());
               }
           }
        }

        /**
         * Grouping and Aggregating with Other Operations
         * summingInt, summingDouble, summingLong
         */
        Map<String,Double> mp3 = l1.stream().collect(Collectors.groupingBy(Item::getItemName,Collectors.summingDouble(Item::getItemPrice)));

        for(Map.Entry<String,Double> entry: mp3.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("Value:"+entry.getValue());
        }

    }
}
