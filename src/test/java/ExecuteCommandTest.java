import org.junit.Assert;
import org.junit.Test;
import test.rea.robot.Direction;
import test.rea.robot.ExecuteCommand;
import test.rea.robot.models.Robot;

import java.util.logging.Logger;

public class ExecuteCommandTest {
    ExecuteCommand executeCommand = new ExecuteCommand();
    Logger logger = Logger.getLogger("ExecuteCommandTest");
    @Test
    public void testExecutePlace(){
        Robot robot = new Robot(false);
        executeCommand.executePlace(1,2,Direction.EAST,robot);
        Assert.assertEquals(robot.getDirection(),Direction.EAST);
    }

    @Test
    public void testExecutePlaceNegative(){
        Robot robot = new Robot(true);
        executeCommand.executePlace(1,2,Direction.EAST,robot);
        Assert.assertNull(robot.getDirection());
    }

    @Test
    public void testExecutePlaceNegativeCoordinates(){
        Robot robot = new Robot(false);
        executeCommand.executePlace(4,-5,Direction.EAST,robot);
        Assert.assertNull(robot.getDirection());
    }

    @Test
    public void testExecuteLeft(){
        Robot robot = new Robot(1,1,Direction.EAST,true);
        executeCommand.turnLeft(robot);
        Assert.assertEquals(Direction.NORTH,robot.getDirection());
    }

    @Test
    public void testExecuteRight(){
        Robot robot = new Robot(1,1,Direction.EAST,true);
        executeCommand.turnRight(robot);
        Assert.assertEquals(Direction.SOUTH,robot.getDirection());
    }

    @Test
    public void testExecuteMove(){
        Robot robot = new Robot(1,2,Direction.EAST,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getX();
        Integer expected = 2;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testXmax(){
        Robot robot = new Robot(4,2,Direction.EAST,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getX();
        Integer expected = 4;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testXmin(){
        Robot robot = new Robot(-4,2,Direction.WEST,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getX();
        Integer expected = -4;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testXMaxWithValidDirection(){
        Robot robot = new Robot(-4,2,Direction.NORTH,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getY();
        Integer expected = 3;
        logger.info("The robot is "+robot);
        Assert.assertEquals(expected,actual);
    }
}
