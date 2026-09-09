package org.learning.StreamApi16;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Gatherer;

public class Stream1 {
    public static void main(String[] args) {
        //whenever we want to work with the data which is in our collection without affecting the existing collection
        //the concept of streamApi comes into the picture
        //by creating a stream of data & we can work on it
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        for(Integer i : list) {
            int res = i*2;
            System.out.println(res);
        }
        System.out.println(list);

        //stream Api method
        //consumer is a functional interface
        //the best way to implement functional interface is through lambda expression

        /* Anonymous Inner Class implementation
        Consumer<Integer> consumer = new Consumer<>() {
            @Override
            public void accept(Integer n) {
                System.out.println(n);
            }
        };
        */
        /* Lambda implementation
        Consumer<Integer> consumer= (Integer n) -> System.out.println(n);
         */

        //Whenever we want to use internal loop inorder to iterate over data
        //without using external loop then we can use for each Method
        list.forEach((n) -> System.out.println(n));
    }
}
