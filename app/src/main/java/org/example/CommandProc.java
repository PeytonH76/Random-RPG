package org.example;


import java.util.HashMap;
import java.util.Map;

// Manages and executes commands
class CommandProcessor {
    // Remembers any commands added with the strings to activate the command
    private Map<String, Command> commandMap = new HashMap<>();

    
    public String registerCommand(String action, Command command) {
        commandMap.put(action, command);
        return "Command '" + action;
    }

    // Method to execute the command
    public void processCommand(String action) {
        // Retrieve command
        Command command = commandMap.get(action);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Unknown command: " + action);
        }
    }
    
    // Method to get a command object
    public Command getCommand(String action) {
        return commandMap.get(action);
    }
}
