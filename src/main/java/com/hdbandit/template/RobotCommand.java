package com.hdbandit.template;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RobotCommand {
    
    private String command;
    private ArrayList<String> arguments;
    
    protected RobotCommand() {
        this.arguments = new ArrayList<String>();
    }
    
    public RobotCommand cmd(String command) {
        this.command = command;
        return this;
    }
    
    public RobotCommand arg(String argument) {
        this.arguments.add(argument);
        return this;
    }
    
    public String getCommand() {
        return command;
    }

    public List<String> getArguments() {
        return arguments;
    }

    public static void execute(Consumer<RobotCommand> request) {
        
        System.out.println("Establishing robot conection...");
        System.out.println("Set robot on status READY");
        
        RobotCommand robotCmd = new RobotCommand();
        request.accept(robotCmd);
        
        StringBuilder params = new StringBuilder();
        robotCmd.getArguments().stream().forEach(arg -> params.append(arg + " "));
        
        System.out.println(String.format("Execute robot command: %s %s", robotCmd.getCommand(), params));
        
        System.out.println("Set robot on status IDLE");
        
    }
    
}
