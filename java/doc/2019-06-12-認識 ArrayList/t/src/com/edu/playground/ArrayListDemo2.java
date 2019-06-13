package com.edu.playground;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayListDemo2 {

    public static void main(String[] args) {
        // 使用 ListOfInt 類別模擬 ArrayList 操作
        ListOfInt list = new ListOfInt();
        Scanner sc = new Scanner(System.in);

        while (true) {
            // ex: add 177
            System.out.println("請輸入指令:");
            String cmdName = sc.next();
            if (cmdName.equals("add")) {
                int height = sc.nextInt();
                list.add(height);
            }

            // 印出現況
            System.out.print("[");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i != list.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }

}
