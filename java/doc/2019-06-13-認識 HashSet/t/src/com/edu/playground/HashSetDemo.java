package com.edu.playground;

import java.util.ArrayList;
import java.util.Scanner;

public class HashSetDemo {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("請輸入指令");
            String cmdName = sc.next();
            
            if(cmdName.equals("add")) {                
                int number = sc.nextInt();
                boolean existed = false;
                for(Integer n:numbers) {
                    if(number == n) {
                        existed = true;
                        break;
                    }
                }
                if(!existed) {
                    numbers.add(number);
                }
            }
            
            // 印出現況
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
