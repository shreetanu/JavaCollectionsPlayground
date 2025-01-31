package my.practice.datastructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> nums;
    /* nums.add(8);
    nums.add(7);
    nums.add(11);
    nums.add(35);
    or alternatively */
        nums = Arrays.asList(67,90,32,1,2,4);
        System.out.println(Collections.max(nums));
        System.out.println(Collections.min(nums));

        //Reverses the order of sorting, in place
        //Prefer List.sort over Collections.sort -- IMPORTANT
        //Introduced in Java 8
        nums.sort(Collections.reverseOrder());
        System.out.println(nums);
    }
}