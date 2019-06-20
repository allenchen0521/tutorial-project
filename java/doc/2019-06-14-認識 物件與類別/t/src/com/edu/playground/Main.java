package com.edu.playground;

public class Main {

    public static void main(String[] args) {
        // 玩家 A
        Player playerA = new Player("玩家A", 100, 200, 80, 30);
        
        // 玩家 B
        Player playerB = new Player("玩家B", 100, 200, 80, 30);

        int roundNumber = 1;        
        while(playerA.healthPoint > 0 && playerB.healthPoint > 0) {
            System.out.println("========第" + roundNumber + "回合========");
            if(roundNumber % 2 ==1) {
                // 玩家 A 攻擊
                playerA.attack(playerB);
            } else {
                // 玩家 B 攻擊
                playerB.attack(playerA);
            }
            System.out.println(playerA.getStatus());
            System.out.println(playerB.getStatus());
            roundNumber++;
        }
        System.out.println("======== 遊戲結束 ========");
        if(playerA.healthPoint > 0) {
            // name 宣告為 private, 必須用 Getter 讀取
            System.out.println(playerA.getName() + "獲勝");
        } else {
            System.out.println(playerB.getName() + "獲勝");
        }

    }

}
