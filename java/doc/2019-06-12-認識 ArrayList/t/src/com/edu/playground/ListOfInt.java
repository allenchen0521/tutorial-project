package com.edu.playground;

import java.util.Arrays;

public class ListOfInt {
    private int[] arr;
    private int addedCount;
    
    public ListOfInt() {
        this.arr = new int[1];
        this.addedCount = 0;
    }
    
    public void add(int height) {
        if(addedCount == arr.length-1) {
            arr = Arrays.copyOf(arr, arr.length*2);
        }
        arr[addedCount] = height;
        addedCount++;
    }
    
    public int get(int index) {
        return arr[index];
    }
    
    public int size() {
        return addedCount;
    }
}
