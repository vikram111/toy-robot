import org.junit.Assert;
import org.junit.Test;
import test.rea.robot.enums.Direction;
import test.rea.robot.ExecuteCommand;
import test.rea.robot.exceptions.InvalidPositionException;
import test.rea.robot.exceptions.RobotException;
import test.rea.robot.models.Robot;

import java.util.logging.Logger;

public class ExecuteCommandTest {
    ExecuteCommand executeCommand = new ExecuteCommand();
    Logger logger = Logger.getLogger("ExecuteCommandTest");
    @Test
    public void testExecutePlace() throws InvalidPositionException {
        Robot robot = new Robot(false);
        executeCommand.executePlace(1,2,Direction.EAST,robot);
        Assert.assertEquals(robot.getDirection(),Direction.EAST);
    }

    @Test
    public void testExecutePlaceNegative() throws InvalidPositionException{
        Robot robot = new Robot(true);
        executeCommand.executePlace(1,2,Direction.EAST,robot);
        Assert.assertNull(robot.getDirection());
    }

    @Test(expected = InvalidPositionException.class)
    public void testExecutePlaceNegativeCoordinates() throws InvalidPositionException{
        Robot robot = new Robot(false);
        executeCommand.executePlace(4,-5,Direction.EAST,robot);

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
    public void testExecuteMove() throws RobotException {
        Robot robot = new Robot(1,2,Direction.EAST,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getX();
        Integer expected = 2;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testXmax() throws RobotException{
        Robot robot = new Robot(4,2,Direction.EAST,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getX();
        Integer expected = 4;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testXmin() throws RobotException{
        Robot robot = new Robot(-4,2,Direction.WEST,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getX();
        Integer expected = -4;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testXMaxWithValidDirection() throws RobotException{
        Robot robot = new Robot(-4,2,Direction.NORTH,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getY();
        Integer expected = 3;
        logger.info("The robot is "+robot);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testExecuteYMin() throws RobotException{
        Robot robot = new Robot(0,-4,Direction.SOUTH,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getY();
        Integer expected = -4;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testExecuteYMax() throws RobotException{
        Robot robot = new Robot(0,4,Direction.NORTH,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getY();
        Integer expected = 4;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testYMaxWithValidDirection() throws RobotException{
        Robot robot = new Robot(0,4,Direction.EAST,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getX();
        Integer expected = 1;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testYMinWithValidDirection() throws RobotException{
        Robot robot = new Robot(0,-4,Direction.WEST,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getX();
        Integer expected = -1;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testXMinWithValidDirection() throws RobotException{
        Robot robot = new Robot(-4,-4,Direction.EAST,true);
        executeCommand.executeMove(robot);
        Integer actual = robot.getX();
        Integer expected = -3;
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = RobotException.class)
    public void testRobotNotPlaced() throws RobotException{
        Robot robot = new Robot(0,0,Direction.NORTH,false);
        executeCommand.executeMove(robot);
    }


}
