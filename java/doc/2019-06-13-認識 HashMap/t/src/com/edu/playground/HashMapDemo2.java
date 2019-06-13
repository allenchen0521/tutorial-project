package com.edu.playground;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class HashMapDemo2 {

    public static void main(String[] args) {
        HashMap<String, Integer> scoreMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("請輸入指令");
            String cmdName = sc.next();
            if(cmdName.equals("add")) {
                // 新增元素
                String name = sc.next();
                int score = sc.nextInt();
                scoreMap.put(name, score);
            } else if(cmdName.equals("get")) {
                // 查詢元素
                String name = sc.next();

                // 宣告 Integer score 避免 return null
                Integer score = scoreMap.get(name);
                if(score != null) {
                    System.out.println(score);
                }
            } else if(cmdName.equals("remove")) {
                // 刪除元素
                String name = sc.next();
                scoreMap.remove(name);
            } else if(cmdName.equals("containKeys")) {
                // 是否存在 Key 元素
                String name = sc.next();
                boolean existed = scoreMap.containsKey(name);
                System.out.println(existed);
            }
            
            // 印出現況
            System.out.print("[");
            int i = 0;
            for(Entry<String, Integer> entry:scoreMap.entrySet()) {
                String name = entry.getKey();
                Integer score = entry.getValue();
                System.out.print(name + " => " + score);
                if(i != scoreMap.size()-1) {
                    System.out.print(",");
                }
                i++;
            }
            System.out.println("]");
        }

    }
}
