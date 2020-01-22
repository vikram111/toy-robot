package test.rea.robot;


import test.rea.robot.models.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;
import static test.rea.robot.Constants.*;

public class ExecuteCommand implements Icommand{
    Logger logger = Logger.getLogger("test.rea.robot.ExecuteCommand");

    public void executePlace(Integer x, Integer y, Direction direction,Robot robot){
        logger.log(Level.INFO,"Received request to place robot "+x+robot);
        if(x!=null && y!=null && direction !=null && robot.getIsPlacedOnTable()!=null){
            robot.setX(x);
            robot.setY(y);
            robot.setDirection(direction);
            robot.setIsPlacedOnTable(true);
           logger.log(Level.INFO,"Robot placed successfully on the table top at x: +"+x+"y: "+y+" direction: "+direction);
        }
        logger.log(Level.SEVERE,"There was an error while processing the place request");
    }

    public void turnLeft(Robot robot){
        Direction direction = robot.getDirection();
        switch (direction){
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

    public void turnRight(Robot robot) {
        Direction direction = robot.getDirection();
        switch (direction){
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

    public Robot executeMove(Robot robot){
        if(null != robot){
            if(robot.getIsPlacedOnTable()){
                move(robot);
            }
        }
        return robot;
    }

    public void move(Robot robot){
        Integer x = robot.getX();
        Integer y = robot.getY();
        switch (robot.getDirection()){
            case NORTH:
                if(y==Y_MAX){
                    logger.log(Level.SEVERE,"The robot has reached the top of the table and cant move");
                    break;
                }
                robot.setY(y+1);
                break;
            case SOUTH:
                if(y==Y_MIN){
                    logger.log(Level.SEVERE,"The robot has reached the bottom of the table and cant move");
                    break;
                }
                robot.setY(y-1);
                break;
            case EAST:
                if(x==X_MAX){
                    logger.log(Level.SEVERE,"The robot has reached the right end of the table and cant move");
                    break;
                }
                robot.setX(x+1);
                break;
            case WEST:
                if(x==X_MIN){
                    logger.log(Level.SEVERE,"The robot has reached the left end of the table and cant move");
                    break;
                }
                robot.setX(x-1);
                break;
        }
    }

}
