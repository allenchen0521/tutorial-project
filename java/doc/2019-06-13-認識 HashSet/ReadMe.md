# 2019-06-13-認識 HashSet

## 情境&思考

```sh
設計一程式, 宣告一 ArrayList 用來記錄一些號碼
程式會不斷重複請使用者輸入指令
假設使用者輸入 add 177 指令, 代表想添加一筆 177 的號碼
每一條指令做完, 都要印出 ArrayList 現況

PS: 重複號碼不可加入
```

## HashSet Demo

1. ArrayList 操作

    ```java
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

                    // 線性時間複雜度, 日後 ArrayList 長度越長, 需要搜尋的時間越長
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
    ```

1. HashSet 操作

    ```java
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
    ```

## HashSet 使用時機

```sh
不在乎加入順序(無序)
元素不得重複
辨識元素「存在」需高效率
「加入」元素需高效率
「刪除」元素高效率
```
