package test.rea.robot;

import test.rea.robot.enums.Command;
import test.rea.robot.enums.Direction;
import test.rea.robot.exceptions.InvalidPositionException;
import test.rea.robot.interfaces.ICommand;
import test.rea.robot.models.Robot;

import java.util.Scanner;

/**
 * This is the main class and is the starting point of the application.
 * It takes the input from the command line and moves the robots as per the specified commands
 */
public class ToyRobot {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InvalidPositionException {
        ICommand executeCommand = new ExecuteCommand();
        ToyRobot toyRobot = new ToyRobot();
        Robot robot = null;
        while(scanner.hasNext()){
            Command command = null;
            Integer x = null;
            Integer y = null;
            Direction direction = null;
            String[] items = scanner.nextLine().split(" ");
            if(items.length>2){
                System.out.println("Invalid number of arguments in one line");
            }
            if(items.length==2){
                command = Command.valueOf(items[0]);
                if(Command.PLACE == command){
                    robot = new Robot(false);
                    String[] placeArguments = items[1].split(",");
                    x = Integer.parseInt(placeArguments[0]);
                    y = Integer.parseInt(placeArguments[1]);
                    direction = Direction.valueOf(placeArguments[2]);
                    executeCommand.executePlace(x,y,direction,robot);
                }
            }else{
                command = Command.valueOf(items[0]);
                executeCommand.executeCommand(command,robot);
            }
        }
    }
}
