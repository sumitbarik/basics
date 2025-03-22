package com.study.basics.sample;

import java.util.*;

public class Practice {

    public static void main(String[] args) {
        System.out.println("treeset::");

        Set<String> treeSet = new TreeSet<>(Comparator.comparing(String::length));
        treeSet.add("Sumit Barik");
        treeSet.add("Divya Biswal");
        treeSet.add("Swaroop Panda");
        treeSet.add("Sanket Padhy");

        treeSet.forEach(System.out::println);

        System.out.println("hashset::");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Sumit Barik");
        hashSet.add("Divya Biswal");
        hashSet.add("Swaroop Panda");
        hashSet.add("Sanket Padhy");

        hashSet.forEach(System.out::println);
        System.out.println("sortedset::");

        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("Sumit Barik");
        sortedSet.add("Divya Biswal");
        sortedSet.add("Swaroop Panda");
        sortedSet.add("Sanket Padhy");

        sortedSet.forEach(System.out::println);
    }
}
