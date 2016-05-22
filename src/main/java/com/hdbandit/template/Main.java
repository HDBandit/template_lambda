package com.hdbandit.template;

public class Main {

    public static void main(String[] args) {
        
     RobotCommand.execute(command -> 
                             command.cmd("MOVE")
                                    .arg("-from 130")
                                    .arg("-to 200")
                                    .arg("-speed 5"));
    }

}
