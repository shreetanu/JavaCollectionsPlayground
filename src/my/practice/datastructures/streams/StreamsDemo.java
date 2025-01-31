package my.practice.datastructures.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(71,71,8,9,10,5);
        /**
         * stream().distinct() - removes duplicates
         */
        List<Integer> list2 = list.stream().distinct().toList();
        for( Integer i: list2) {
            System.out.println("Element:"+i);
        }

        /**
         * stream.collect(Collectors.toSet())
         */
        Set<Integer> s1 = list.stream().collect(Collectors.toSet());

        for(Integer i: s1) {
            System.out.println("Element of set:"+i);
        }

        list.stream().forEach( l1 -> System.out.println("LIST EL"+l1));
    }
}
