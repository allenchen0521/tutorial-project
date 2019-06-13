package com.edu.playground;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo3 {

    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("請輸入指令");
            String cmdName = sc.next();

            if(cmdName.equals("add")) {
                // 新增元素
                int height = sc.nextInt();
                heights.add(height);
            } else if(cmdName.equals("removeAt")) {
                // 刪除元素
                int index = sc.nextInt();
                heights.remove(index);
            } else if(cmdName.equals("insert")) {
                // 插入元素
                int index = sc.nextInt();
                int height = sc.nextInt();
                heights.add(index, height);
            } else if(cmdName.equals("update")) {
                // 更新元素
                int index = sc.nextInt();
                int height = sc.nextInt();
                heights.set(index, height);
            } else if(cmdName.equals("clear")) {
                // 清空元素
                heights.clear();
            }
            
            System.out.print("[");
//            for(int i = 0;i < heights.size();i++) {
//                System.out.print(heights.get(i));
//                if(i != heights.size()-1) {
//                    System.out.print(",");
//                }
//            }
            
            // ArrayList use foreach
            // foreach 沒有索引, 所以需要宣告計數器
            int i = 0;
            for(Integer height:heights) {
                System.out.print(height);
                if(i != heights.size()-1) {
                    System.out.print(",");
                }
                i++;
            }
            System.out.println("]");
        }

    }

}
