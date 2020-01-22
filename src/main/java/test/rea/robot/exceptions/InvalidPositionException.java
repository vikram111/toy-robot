package test.rea.robot.exceptions;

import test.rea.robot.ExecuteCommand;

public class InvalidPositionException extends Exception {
    public InvalidPositionException(String message){
        super(message);
    }
}
