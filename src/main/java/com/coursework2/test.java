package com.coursework2;

import java.util.ArrayList;
import java.util.Random;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(321);
        list.add(12312);
        list.add(12321312);
        list.add(123563212);
        list.add(124324312);
        list.add(1312);

        System.out.println("до удаления " + list);
        list.remove(1);
        System.out.println("после удаления " + list);
    }
}
