package org.example;


abstract class Character {
    String name;
    int health;
    int attackPower;
    int defense;
    
    public Character(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
    }
    
    public abstract String getGender();
    
    public abstract String getPronounHeShe();
    public abstract String getPronounHimHer();
    public abstract String getPronounHisHer();
    
    public abstract String getFirstName();
    
    public abstract String characterData();
    
    public abstract String characterName();
    
    public abstract void attack(Character target);
    
    public abstract int getHealth();
}

class Player extends Character {
    //Creat a list of main player names
        static String[][] names = {
                {"Cain Smith", "male"},
                {"Sally Smith", "female"},
                {"Curry Smith", "male"},
                {"Silvers Smith", "male"},
                {"Hill Smith", "male"},
                {"Gallahager Smith", "male"},
                {"Cecot Smith", "female"},
                {"Stormval Smith", "male"},
                {"Leon S. Kennady", "male"},
                {"Jill Valentine", "female"},
                {"Cris Redfield", "male"},
                {"Claire Redfield", "female"},
                {"Ada Wong", "female"},
                {"Luigi Plummer", "male"},
                {"Mario Plummer", "male"},
                {"Wario Plummer", "male"},
                {"Waluigi Plummer", "male"},
                {"Edelgard", "female"}
            };
        private String gender;
    // Player constructor
    public Player(String name, String gender, int health, int attackPower, int defense){
        super(name, health, attackPower, defense);
        this.gender = gender;
    }
    
    public String getGender(){
        return gender;
    }
    
    // Determine wether the character is male or female
    public String getPronounHeShe() {
        return gender.equals("male") ? "he" : "she";
    }
    
    public String getPronounHimHer() {
        return gender.equals("male") ? "him" : "her";
    }
    
    public String getPronounHisHer() {
        return gender.equals("male") ? "his" : "her";
    }
    
    public String getFirstName() {
        // Split the name by spaces and return the first part
        return name.split(" ")[0];
    }
    
    
    // Get player data
    public String characterData(){
        return " Name: " + this.name + "\n Health: " + this.health + "\n Attack: " + this.attackPower + "\n Defense: " + this.defense;
    }
    
    public String characterName(){
        return this.name;
    }
    
    // Subtract the health from the attack power
    public void attack(Character target) {
        System.out.println(name + " attacks " + target.name + " for " + attackPower + " damage.");
        target.health -= attackPower;
    }
    public int getHealth(){
        return this.health;
    }
}

class Enemy extends Character {
    
    static String[] names = {"Goblin", "Skeleton", "Zombie", "Wolf", "Golem"};
    private String gender;
    public Enemy(String name, int health, int attackPower, int defense){
        super(name, health, attackPower, defense);
    }
    
    public String characterData(){
        return " Name: " + this.name + "\n Health: " + this.health + "\n Attack: " + this.attackPower + "\n Defense: " + this.defense;
    }
    
    public String getGender(){
        return gender;
    }
    
    // Determine wether the character is male or female
    public String getPronounHeShe() {
        return gender.equals("male") ? "he" : "she";
    }
    
    public String getPronounHimHer() {
        return gender.equals("male") ? "him" : "her";
    }
    
    public String getPronounHisHer() {
        return gender.equals("male") ? "his" : "her";
    }
    
    public String getFirstName() {
        // Split the name by spaces and return the first part
        return name.split(" ")[0];
    }
    
    public String characterName(){
        return this.name;
    }
    
    public void attack(Character target) {
        System.out.println(name + " attacks " + target.name + " for " + attackPower + " damage.");
        target.health -= attackPower;
    }
    
    public int getHealth(){
        return this.health;
    }
    
}
 
class Ally extends Character {

    static String[][] names = {
            {"John Solo", "male"},
            {"Jack Skywalker", "male"},
            {"Captain Solo", "female"},
            {"Eliza Wiess", "female"},
            {"Joker Jenkins", "male"},
            {"Morales Fischer", "male"},
            {"Lisa Mika", "female"},
            {"Sally Carwright", "female"},
            {"Carlos Oliveira", "male"},
            {"Rebecca Chambers", "female"},
            {"Nephi", "male"},
            {"Sarah Solo", "female"},
            {"Claude von Regien", "male"}
    };
    private String gender;
    // Player constructor
    public Ally(String name, String gender, int health, int attackPower, int defense){
        super(name, health, attackPower, defense);
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    // Determine wether the character is male or female
    public String getPronounHeShe() {
        return gender.equals("male") ? "he" : "she";
    }
    
    public String getPronounHimHer() {
        return gender.equals("male") ? "him" : "her";
    }
    
    public String getPronounHisHer() {
        return gender.equals("male") ? "his" : "her";
    }

    public String getFirstName() {
        // Split the name by spaces and return the first part
        return name.split(" ")[0];
    }


    // Get player data
    public String characterData(){
        return " Name: " + this.name + "\n Health: " + this.health + "\n Attack: " + this.attackPower + "\n Defense: " + this.defense;
    }

    public String characterName(){
        return this.name;
    }

    public void attack(Character target) {
        System.out.println(name + " attacks " + target.name + " for " + attackPower + " damage.");
        target.health -= attackPower;
    }
    
    public int getHealth(){
        return this.health;
    }
}