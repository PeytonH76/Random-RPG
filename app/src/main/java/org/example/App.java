package org.example;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        // Player
        int playerHealth = random.nextInt(101) + 75;
        int playerAttackPower = random.nextInt(11) + 10;
        int playerDefense = random.nextInt(5) + 1;
        
        // Enemy 1
        int enemy1Health = random.nextInt(51) + 25;
        int enemy1AttackPower = random.nextInt(6) + 5;
        int enemy1Defense = random.nextInt(3) + 1;
        
        // Ally 1
        int ally1Health = random.nextInt(81) + 75;
        int ally1AttackPower = random.nextInt(11) + 20;
        int ally1Defense = random.nextInt(3) + 1;
        
        // Ally 2
        int ally2Health = random.nextInt(76) + 100;
        int ally2AttackPower = random.nextInt(11) + 10;
        int ally2Defense = random.nextInt(5) + 5;
        
        // Select random player data from the Player class
        String[] selectedPlayerData = Player.names[random.nextInt(Player.names.length)];
        Player player = new Player(selectedPlayerData[0], selectedPlayerData[1], playerHealth, playerAttackPower, playerDefense);
        
        Enemy enemy = new Enemy(Enemy.names[random.nextInt(Enemy.names.length)], enemy1Health, enemy1AttackPower, enemy1Defense);
        String[] selectedAllyData1 = Ally.names[random.nextInt(Ally.names.length)];
        String[] selectedAllyData2 = Ally.names[random.nextInt(Ally.names.length)];
        Ally ally1 = new Ally(selectedAllyData1[0], selectedAllyData1[1], ally1Health, ally1AttackPower, ally1Defense);
        Ally ally2 = new Ally(selectedAllyData2[0], selectedAllyData2[1], ally2Health, ally2AttackPower, ally2Defense);
        
        System.out.println("Welcome to an RPG game!\n\n");
        
        Story1 story1 = new Story1(player, enemy, ally1, ally2);
        story1.story1();
        
    }
}