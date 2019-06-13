# 2019-06-12-認識 ArrayList

## 情境&思考

```sh
設計一個程式, 宣告一個陣列用來記錄身高
程式會不斷重複請使用者輸入指令
假設使用者輸入「add 177」指令, 代表使用者添加一筆身高 177 的資料
每一條指令做完後, 都要印出陣列的現況
```

## ArrayList 使用時機

1. int[] 儲存

    ```java
    package com.edu.playground;

    public class ArrayListDemo{

        public static void main(Strings[] args){
            // Array 宣告需要固定長度
            int[] heights = new int[1];
            Scanner sc = new Scanner(System.in);

            // 需要計數器, 得知新增的索引位置
            int addedCount = 0;

            while(true){
                // ex: add 177
                System.out.println("請輸入指令:");
                String cmdName = sc.next();
                if(cmdName.equals("add")){
                    if(addedCount == heights.length){
                        // 複製原本的陣列且將長度擴展 2 倍
                        heights = Arrays.copyOf(heights, heights.length*2);
                    }
                    int height = sc.nextInt();
                    heights[addedCount] = height;
                    addedCount++;
                }

                // 印出現況
                System.out.print("[");
                for(int i = 0;i < addedCount;i++){
                    System.out.print(heights[i]);
                    if(i != addedCount-1){
                        System.out.print(",");
                    }
                }
                System.out.println("]");
            }
        }
    }
    ```

1. 模仿 ArrayList 操作

    ```java
    // ListOfInt.java
    package com.edu.playground;

    public class ListOfInt{
        private int[] arr;
        private int addedCount;

        public ListOfInt(){
            this.arr = new int[1];
            this.addedCount = 0;
        }

        public void add(int height){
            if(addedCount == arr.length){
                arr = Arrays.copyOf(arr, arr.length*2);
            }
            arr[addedCount] = height;
            addedCount++;
        }

        public int get(int index){
            return arr[index];
        }

        public int size(){
            return addedCount;
        }
    }
    ```

1. ArrayList 操作

    ```java
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
    ```

## Array ArrayList 差異

1. Array 相同

    ```sh
    元素有序
    以索引找元素
    ```

1. Array 不相同

    ```sh
    預設大小為 0, 隨需要自動增長
    提供更多方便操作(ex: 新增/刪除/插入)
    ```
