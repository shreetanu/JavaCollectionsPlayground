package my.practice.datastructures.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Person {
    String name;
    int age;

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }
}

public class PriorityQueueDemo {
    public static void main(String[] args) {
        /**
         * A basic Priority Queue which by default sorts in ascending order
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(89);
        pq.offer(1);
        pq.offer(3);

        //Output is 1, because min heap
        System.out.println("AT PEEK"+pq.peek());

        List<Person> l1 = Arrays.asList(new Person("Tanushree",24),new Person("Vaidehi",23),new Person("Vanshika",25));

        /**
         * Accepts a function that extracts an int sort key from a type T,
         * and returns a Comparator<T> that compares by that sort key.
         */
        l1.sort(Comparator.comparingInt(p1 -> p1.age));


        //Sorted, gives Vaidehi as output
        System.out.println("Peek of list is"+l1.get(0).name);

        PriorityQueue<Person> pqPerson = new PriorityQueue<>(Comparator.comparing(p1 -> p1.name));

        pqPerson.offer(new Person("Tanushree",24));
        pqPerson.offer(new Person("Jay",22));
        pqPerson.offer(new Person("Vaid",23));

        //Output is JAY
        System.out.println("ATPEEK AGAIN"+pqPerson.peek().name);


    }
}
