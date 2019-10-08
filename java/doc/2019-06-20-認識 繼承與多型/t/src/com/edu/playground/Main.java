package com.edu.playground;

public class Main {

    public static void main(String[] args) {
        // Player A 玩家
        Player playerA = new Warrior("玩家A", 100, 200, 80, 30, 0.7);

        // Player B 玩家
        Player playerB = new Player("玩家B", 100, 200, 80, 30);
        int roundNumber = 1;
        System.out.println("========遊戲開始========");
        while(playerA.alive() && playerB.alive()) {
            System.out.println("========第" + roundNumber + "回合========");
            if(roundNumber % 2 == 1) {
                // Player A 攻擊
                playerA.attack(playerB);
            }else {
                // Player B 攻擊
                playerB.attack(playerA);
            }
            System.out.println(playerA.getStatus());
            System.out.println(playerB.getStatus());
            roundNumber++;
        }
        System.out.println("========遊戲開始========");
        if(playerA.alive()) {
            System.out.println(playerA.getName() + "獲勝");
        }else {
            System.out.println(playerB.getName() + "獲勝");
        }
    }

}
