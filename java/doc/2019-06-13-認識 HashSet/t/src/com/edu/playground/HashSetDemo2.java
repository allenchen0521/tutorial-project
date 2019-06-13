package com.edu.playground;

import java.util.HashSet;
import java.util.Scanner;

public class HashSetDemo2 {

    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("請輸入指令");
            String cmdName = sc.next();
            
            if(cmdName.equals("add")) {
                // 新增元素
                int number = sc.nextInt();
                numbers.add(number);
            } else if(cmdName.equals("remove")) {
                // 刪除元素
                int number = sc.nextInt();
                numbers.remove(number);
            } else if(cmdName.equals("contains")) {
                // 元素是否存在
                int number = sc.nextInt();
                boolean existed = numbers.contains(number);
                System.out.println(existed);
            }
            
            int i = 0;
            System.out.print("[");
            for(Integer number:numbers) {
                System.out.print(number);
                if(i != numbers.size()-1) {
                    System.out.print(",");
                }
                i++;
            }
            System.out.println("]");
        }

    }

}
