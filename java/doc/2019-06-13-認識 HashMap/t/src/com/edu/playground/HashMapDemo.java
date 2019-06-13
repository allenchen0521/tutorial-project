package com.edu.playground;

import java.util.ArrayList;
import java.util.Scanner;

import sun.launcher.resources.launcher;

public class HashMapDemo {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            System.out.println("請輸入指令");
            String cmdName = sc.next();

            if(cmdName.equals("add")) {
                String name = sc.next();
                int score = sc.nextInt();
                names.add(name);
                scores.add(score);
            } else if(cmdName.equals("get")){
                String name = sc.next();
                for(int i = 0;i < names.size();i++) {
                    if(names.get(i).equals(name)) {
                        System.out.println(scores.get(i));
                        break;
                    }
                }
            }

            // 印出現況
            System.out.print("[");
            for(int i = 0;i < names.size();i++) {
                System.out.print(names.get(i) + " => " + scores.get(i));
                if(i != names.size()-1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }

    }

}
