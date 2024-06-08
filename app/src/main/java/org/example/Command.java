package org.example;


interface Command {
    void execute();
}

// Implement the command interface with the attack command
class AttackCommand implements Command {
    private Character attacker;
    private Character target;
    
    // Constructer to intialize attacker and target characters
    public AttackCommand(Character attacker, Character target) {
        this.attacker = attacker;
        this.target = target;
    }

    // Changes the target of the attack
    public void setTarget(Character target) {
        this.target = target;
    }
    
    // Override the execute method to attack
    @Override
    public void execute() {
        attacker.attack(target);
    }
}
 
class HealCommand implements Command {
    private Character character;
    private int healAmount;

    public HealCommand(Character character, int healAmount) {
        this.character = character;
        this.healAmount = healAmount;
    }

    @Override
    public void execute() {
        System.out.println(character.name + " heals for " + healAmount + " health.");
        // Increase characters health by the heal amount
        character.health += healAmount;
    }
}
