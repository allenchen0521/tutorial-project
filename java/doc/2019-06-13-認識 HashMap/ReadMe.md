# 2019-06-13-認識 HashMap

## 情境&思考

```sh
設計一個程式, 用來記錄學生成績單
當使用者輸入指令, add John 90, 代表要記錄 John 考 90 分
程式會不斷重複請使用者輸入指令
每一條指令做完後, 都要印出成績單現況
```

## HashMap Demo

1. ArrayList 操作

    ```java
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
    ```

1. HashMap 操作

    ```java
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
    ```

## HashMap 使用時機

```sh
不在乎加入順序(無序)
Key 不得重複
以「key 找 Value」需高效率
辨識「Key存在性」需高效率
「加入元素」需高效率
```
