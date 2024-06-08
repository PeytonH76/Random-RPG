package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Story1 {
    private Player player;
    private Enemy enemy;
    private Ally ally1;
    private Ally ally2;
    private Random random = new Random();
    private CommandProcessor commandProcessor;
    public Story1(Player player, Enemy enemy, Ally ally1, Ally ally2){
        this.player = player;
        this.enemy = enemy;
        this.ally1 = ally1;
        this.ally2 = ally2;
        this.commandProcessor = new CommandProcessor();
        registerCommands();
    }

    // Register all commands needed in the story
    private void registerCommands() {
        commandProcessor.registerCommand("playerAttack", new AttackCommand(player, null));
        commandProcessor.registerCommand("playerHeal", new HealCommand(player, random.nextInt(16) + 10));

        // Register commands for allies' attacks
        commandProcessor.registerCommand("ally1Attack", new AttackCommand(ally1, null));
        commandProcessor.registerCommand("ally2Attack", new AttackCommand(ally2, null));

        // Register command for enemy's attack
        commandProcessor.registerCommand("enemyAttack", new AttackCommand(enemy, null));
    }

    public void story1(){

        String playerData = player.characterData();
        String enemyData = enemy.characterData();
        String playerFullName = player.characterName();
        String playerFirstName = player.getFirstName();
        String enemyName = enemy.characterName();


        System.out.println("Here is the main character data: \n" + player.characterData() + "\n \n");
        System.out.println("Stranger 1: Hello?");
        System.out.println("When you open your eyes, you see a grey, gloomy sky. \n" +
                           "Snow is falling. You sit up and see two strangers looking at you.\n" +
                           "Stranger 1: Are you ok?\n" +
                           playerFirstName + ": Yeah.\n" +
                           "Stranger 1: What happened?\n" +
                           playerFirstName + ": I don't know.\n" +
                           "Stranger 1: You don't look so well. There's a town near by where we can get you some help.\n" +
                           "Can you walk?\n" +
                           playerFirstName + ": Yeah I should be good.\n" +
                           "Stranger 1: Alright, let's get going. Oh! I didn't introduce myself. \n" +
                           "I'm " + ally1.getFirstName() + " and " + ally2.getPronounHisHer() + " name is " + ally2.getFirstName() + " \n" +
                           ally2.getFirstName() + ": Hello! \n" + ally1.getFirstName() + " holds " + ally1.getPronounHisHer() + " hand out. \n" +
                           "You notice " + ally1.getPronounHisHer() + " hand and grab it. Then " + ally1.getFirstName() + " helps you up. \n"+
                           ally1.getFirstName() + ": Come on, let's get going to the town.\n" +
                           "You start heading down a snowy path that looks like it's been used before.\n" +
                           ally2.getFirstName() + ": There are three ways to get to the town from here.\n" +
                           ally2.getFirstName() + "We continue down this path, go through the trees, or go down the left path.\n");

        // Randomly decide the next part of the story
        int storyOption = random.nextInt(3);
        switch (storyOption) {
            case 0:
                storyPart1();
                break;
                case 1:
                    storyPart2();
                    break;
                    case 2:
                        storyPart3();
                        break;
        }


    }
    private void storyPart1() {
        System.out.println("You decide to go down the normal path. \n" +
                           "As you start going down the path. You see" +
                           " something standing alone down the road. " +
                           "As you walk closer, you see the outline of the creature. \n" +
                           ally1.getFirstName() + ": Guys, that's a " + enemy.getFirstName() + ".\n");
        randomCombat();
    }

    private void storyPart2() {
        System.out.println("You decide to go down the left path." +
                           "At about a mile into the left path, you see a creature jump out of the forest closest to " + ally1.getFirstName() + ".\n" +
                           ally2.getFirstName() + ": Watch out!\n");
        randomCombat();
    }

    private void storyPart3() {
        System.out.println("You decide to go into the forrest.\n" +
                           "As soon as you go into the forrest, a creatur jumps out at you. \n");
        randomCombat();
    }

    private void randomCombat() {
        String[] combatActions = {"playerAttack", "playerHeal"};

        // Player's turn
        String playerAction = combatActions[random.nextInt(combatActions.length)];
        ((AttackCommand) commandProcessor.getCommand("playerAttack")).setTarget(getRandomTarget(enemy));
        commandProcessor.processCommand(playerAction);

        // Allies' turns
        ((AttackCommand) commandProcessor.getCommand("ally1Attack")).setTarget(getRandomTarget(enemy));
        commandProcessor.processCommand("ally1Attack");

        ((AttackCommand) commandProcessor.getCommand("ally2Attack")).setTarget(getRandomTarget(enemy));
        commandProcessor.processCommand("ally2Attack");

        // Enemy's turn
        ((AttackCommand) commandProcessor.getCommand("enemyAttack")).setTarget(getRandomTarget(player, ally1, ally2));
        commandProcessor.processCommand("enemyAttack");

        // Continue combat loop or end based on conditions (e.g., health status)
        if (enemy.getHealth() > 0 && player.getHealth() > 0) {
            randomCombat(); // Continue combat if the enemy and player are still alive
        } else if (enemy.getHealth() <= 0) {
            System.out.println("The enemy has been defeated!");
        } else if (player.getHealth() <= 0) {
            System.out.println("You have been defeated by the enemy!");
        }
    }

    // Get a random target from possible targets
    private Character getRandomTarget(Character... possibleTargets) {
        List<Character> validTargets = new ArrayList<>();
        for (Character target : possibleTargets) {
            if (target != ally1 && target != ally2) { // Allies don't attack each other
                validTargets.add(target);
            }
        }
        return validTargets.get(random.nextInt(validTargets.size()));
    }
}