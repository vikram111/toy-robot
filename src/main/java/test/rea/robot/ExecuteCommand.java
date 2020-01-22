package test.rea.robot;


import test.rea.robot.enums.Command;
import test.rea.robot.enums.Direction;
import test.rea.robot.exceptions.InvalidPositionException;
import test.rea.robot.exceptions.RobotException;
import test.rea.robot.interfaces.Icommand;
import test.rea.robot.models.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;
import static test.rea.robot.Constants.*;

public class ExecuteCommand implements Icommand {
    Logger logger = Logger.getLogger("test.rea.robot.ExecuteCommand");

    private boolean isValidPosition(Integer x, Integer y){
        return !(x>X_MAX || x<X_MIN || y>Y_MAX || y<Y_MIN);
    }

    public void executePlace(Integer x, Integer y, Direction direction, Robot robot) throws InvalidPositionException{
        logger.log(Level.INFO,"Received request to place robot "+robot);
        if(x!=null && y!=null && direction !=null && robot.getIsPlacedOnTable()!=null && !robot.getIsPlacedOnTable()){
            if(isValidPosition(x,y)){
                robot.setX(x);
                robot.setY(y);
                robot.setDirection(direction);
                robot.setIsPlacedOnTable(true);
                logger.log(Level.INFO,"Robot placed successfully on the table top at "+robot);
            }else{
                System.out.println("The provided parameters for the request are invalid " + x + "," + y + "," + robot);
                logger.log(Level.SEVERE, "The provided parameters for the request are invalid " + x + "," + y + "," + robot);
                throw new InvalidPositionException("The provided parameters for the request are invalid " + x + "," + y);
            }
        }else {
            logger.log(Level.SEVERE, "The provided parameters for the request are invalid " + x + "," + y + "," + robot);
        }
    }

    public void turnLeft(Robot robot){
        if(robot !=null && robot.getIsPlacedOnTable()) {
            Direction direction = robot.getDirection();
            switch (direction) {
                case EAST:
                    robot.setDirection(Direction.NORTH);
                    break;
                case WEST:
                    robot.setDirection(Direction.SOUTH);
                    break;
                case NORTH:
                    robot.setDirection(Direction.WEST);
                    break;
                case SOUTH:
                    robot.setDirection(Direction.EAST);
                    break;
            }
        }
    }

    public void turnRight(Robot robot) {
        if(robot !=null && robot.getIsPlacedOnTable()) {
            Direction direction = robot.getDirection();
            switch (direction) {
                case EAST:
                    robot.setDirection(Direction.SOUTH);
                    break;
                case WEST:
                    robot.setDirection(Direction.NORTH);
                    break;
                case NORTH:
                    robot.setDirection(Direction.EAST);
                    break;
                case SOUTH:
                    robot.setDirection(Direction.WEST);
                    break;
            }
        }
    }

    public void executeMove(Robot robot) throws RobotException{
        if(null != robot && robot.getIsPlacedOnTable()){
                move(robot);
        }else{
            throw new RobotException("The robot is not placed on the table");
        }
    }

    public void move(Robot robot) {
            Integer x = robot.getX();
            Integer y = robot.getY();
            switch (robot.getDirection()) {
                case NORTH:
                    if (y == Y_MAX) {
                        logger.log(Level.SEVERE, "The robot has reached the top of the table and cant move");
                        break;
                    }
                    robot.setY(y + 1);
                    break;
                case SOUTH:
                    if (y == Y_MIN) {
                        logger.log(Level.SEVERE, "The robot has reached the bottom of the table and cant move");
                        break;
                    }
                    robot.setY(y - 1);
                    break;
                case EAST:
                    if (x == X_MAX) {
                        logger.log(Level.SEVERE, "The robot has reached the right end of the table and cant move");
                        break;
                    }
                    robot.setX(x + 1);
                    break;
                case WEST:
                    if (x == X_MIN) {
                        logger.log(Level.SEVERE, "The robot has reached the left end of the table and cant move");
                        break;
                    }
                    robot.setX(x - 1);
                    break;
            }
    }

    public void executeCommand(Command command,Robot robot) {
        switch (command) {
            case LEFT:
                turnLeft(robot);
                break;
            case RIGHT:
                turnRight(robot);
                break;
            case MOVE:
                try {
                    executeMove(robot);
                    break;
                }catch (RobotException robotException){
                    logger.severe("There was an exception while executing move "+robotException.getMessage());
                }

            case REPORT:
                System.out.println(robot);
                break;

        }
    }

}
