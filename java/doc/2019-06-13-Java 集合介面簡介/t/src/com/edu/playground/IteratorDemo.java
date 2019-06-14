package com.edu.playground;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.util.converter.NumberStringConverter;

public class IteratorDemo {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Allen");
        names.add("Aaron");
        names.add("Tommy");

        // ArrayList implements Iterable 介面, 其中 Iterator() return Iterator<E> 介面
        // Iterator 物件印出現況
        Iterator<String> iteranames = names.iterator();
        while(iteranames.hasNext()) {
            System.out.println(iteranames.next());
        }
        
    }

}
