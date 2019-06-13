package com.edu.playground;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayListDemo {

    public static void main(String[] args) {
        // Array 宣告需要固定長度
        int[] heights = new int[1];
        Scanner sc = new Scanner(System.in);

        // 需要計數器, 得知新增的索引位置
        int addedCount = 0;

        while (true) {
            // ex: add 177
            System.out.println("請輸入指令:");
            String cmdName = sc.next();
            if (cmdName.equals("add")) {
                if(addedCount == heights.length) {
                    heights = Arrays.copyOf(heights, heights.length*2);
                }
                int height = sc.nextInt();
                heights[addedCount] = height;
                addedCount++;
            }

            // 印出現況
            System.out.print("[");
            for (int i = 0; i < addedCount; i++) {
                System.out.print(heights[i]);
                if (i != addedCount - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }
}