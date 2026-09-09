package org.learning.StreamApi16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2 {
    public static void main(String[] args){
        System.out.println("EXAMPLE 1");
//  I want to work with this data which is in our collection without affecting the existing collection
//  This data should not be affected
        List<Integer> list1 = new ArrayList<>();
            list1.add(2);
            list1.add(1);
            list1.add(3);
            list1.add(4);
            list1.add(5);
            System.out.println(list1);
//  With the help of collection sorts data of collection data is getting sorted and its affecting existing collection
//        Collections.sort(list1);
//        System.out.println(list1);

        //  APPROACH 1

//  I want to sort without affecting the original collection
//  1) Create a stream of this collection
    Stream<Integer> streamData1 = list1.stream();
    Stream<Integer> sortedStream =  streamData1.sorted();
//  sortedStream.forEach(n->System.out.println(n));
    Stream<Object> streamData2 = sortedStream.map(n->n*2);
    streamData2.forEach(n->System.out.println(n));
    System.out.println(list1);
/*  on One stream we can perform only one operation
    Once stream is consumed we can't reuse stream - IllegalStateException error will come.
    Stream method is only for collections
    Stream<Integer> streamdata2 = streamData1.map(n->n*2);
    streamdata2.forEach(n->System.out.println(n));
 */
        // APPROACH 2
        //IN FUTURE CLASSES WE WILL DO
        list1.stream().sorted().map(n->n*2).forEach(n->System.out.println(n));

        System.out.println();
        System.out.println();

        System.out.println("EXAMPLE 2");
        List<String> list2 = new ArrayList<>();
        list2.add("Alien");
        list2.add("Java");
        list2.add("Telusko");
        System.out.println(list2);
        Set<String> set = list2.stream().collect(Collectors.toSet());
        List<String> list3 = set.stream().collect(Collectors.toList());
        System.out.println(list3);
    }
}
