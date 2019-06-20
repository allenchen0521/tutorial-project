# 2019-06-14-認識物件與類別

## 情境&思考

```sh
撰寫一個簡單回合制戰鬥遊戲程式
遊戲有兩位玩家
每位玩家都有:
1. 名稱
2. 生命值
3. 法力值(攻擊他人時要減少 10)
4. 攻擊力
5. 防禦力

每回合兩玩家輪流攻擊
攻擊時: 對手生命造成的傷害之公式為「攻擊方攻擊力 - 受攻擊方防禦力」
攻擊後: 印出雙方完整狀態(HP/MP)
回合直到有一方 HP 歸零, 程式結束, 印出勝敗訊息
```

## 程序導向

1. Main.java

    ```java
    package com.edu.playground;

    import com.sun.xml.internal.ws.resources.HandlerMessages;

    public class Main {

        public static void main(String[] args) {
            // 玩家 A
            String nameA = "玩家A";
            int healthPointA = 100;
            int magicPointA = 200;
            int attackPointA = 80;
            int defensePointA = 30;

            // 玩家 B
            String nameB = "玩家B";
            int healthPointB = 100;
            int magicPointB = 200;
            int attackPointB = 80;
            int defensePointB = 30;

            int roundNumber = 1;        
            while(healthPointA > 0 && healthPointB > 0) {
                System.out.println("========第" + roundNumber + "回合========");
                if(roundNumber % 2 ==1) {
                    // 玩家 A 攻擊
                    if(magicPointA < 0) {
                        System.out.println("法力耗盡, 無法攻擊");
                        continue;
                    } else {
                        magicPointA -= 10;
                        int harm = attackPointA - defensePointB;
                        healthPointB -= harm;
                    }
                } else {
                    // 玩家 B 攻擊
                    if(magicPointB < 0) {
                        System.out.println("法力耗盡, 無法攻擊");
                        continue;
                    } else {
                        magicPointB -= 10;
                        int harm = attackPointB - defensePointA;
                        healthPointA -= harm;
                    }
                }
                System.out.println(nameA + " HP: " + healthPointA + " MP: " + magicPointA);
                System.out.println(nameB + " HP: " + healthPointB + " MP: " + magicPointB);
                roundNumber++;
            }
            System.out.println("======== 遊戲結束 ========");
            if(healthPointA > 0) {
                System.out.println(nameA + "獲勝");
            } else {
                System.out.println(nameB + "獲勝");
            }

        }

    }
    ```

## 物件導向

1. 宣告玩家類別(Class)

    ```java
    com.edu.playground;

    public class Player{
        public String name;
        public int healthPoint;
        public int magicPoint;
        public int attackPoint;
        public int defensePoint;
    }

    // 以上宣吿類別內的變數, 稱為實例變數或實例欄位
    ```

1. 宣告建構方法(Constructor)

    ```sh
    用來建立類別的新實例
    預設為無參數的建構方法
    ```

    ```java
    com.edu.playground;

    public class Player{
        public String name;
        public int healthPoint;
        public int magicPoint;
        public int attackPoint;
        public int defensePoint;

        public Player(String name, int healthPoint, int magicPoint, int attackPoint, int defensePoint){
            this.name = name;
            this.healthPoint = healthPoint;
            this.magicPoint = magicPoint;
            this.attackPoint = attackPoint;
            this.defensePoint = defensePoint;
        }
    }
    ```

1. 實例方法

    ```sh
    建立類別的物件, 呼叫各自的實例方法
    ```

    ```java
    com.edu.playground;

    public class Player{
        public Player(String name, int healthPoint, int magicPoing, int attackPoint, int defensePoint){
            this.name = name;
            this.healthPoint = healthPoint;
            this.magicPoint = magicPoint;
            this.attackPoint = attackPoit;
            this.defensePoint = defensePoint;
        }

        public String getStatus(){
            return name + " HP: " + healthPoint + " MP: " + magicPoint;
        }

        public void attack(Player other){
            if(!canAttack()){
                System.out.println("法力耗盡, 無法攻擊");
                // return attack() method 不執行後續邏輯
                return;
            }
            magicPoint -= 10;
            int harm = attackPoint - other.defensePoint;
            other.healthPoint -= harm;
        }

        public boolean alive(){
            return healthPoint > 0;
        }

        public boolean canAttack(){
            return magicPoint > 10;
        }
    }
    ```

1. Getter & Setter 方法使用

    ```sh
    Getter, Setter 可以做出唯讀變數的效果
    可以在 Setter 內做資料檢核
    ```

    ```java
    com.edu.playground;

    public class Player{
        // 宣告為 private, 外面只能透過 getName() 取得值
        private String name;
        public int healthPoint;
        public int magicPoint;
        public int attackPoint;
        public int defensePoint;

        public Player(String name, int healthPoint, int magicPoint, int attackPoint, int defensePoint){
            this.name = name;
            this.healthPoint = healthPoint;
            this.magicPoint = magicPoint;
            this.attackPoint = attackPoint;
            this.defensePoint = defensePoint;
        }

        // Getter
        public int getName(){
            return name;
        }

        // Setter
        public void setName(String name){
            this.name = name;
        }

        public String getStatus(){
            return name + " HP: " + healthPoint + " MP: " + magicPoint;
        }

        public void attack(Player other){
            if(!canAttack()){
                System.out.println("法力耗盡, 無法攻擊");
                return;
            }
            magicPoint -= 10;
            int harm = attackPoint - other.defensePoint;
            other.healthPoint -= harm;
        }

        public boolean canAttack(){
            return magicPoint > 10;
        }

        public boolean alive(){
            return healthPoint > 0;
        }
    }
    ```
