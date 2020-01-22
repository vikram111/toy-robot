import org.junit.Assert;
import org.junit.Test;
import test.rea.robot.Direction;
import test.rea.robot.ExecuteCommand;
import test.rea.robot.models.Robot;

public class ExecuteCommandTest {
    ExecuteCommand executeCommand = new ExecuteCommand();

    @Test
    public void testExecutePlace(){
        Robot robot = new Robot();
        robot.setIsPlacedOnTable(false);
        executeCommand.executePlace(1,2,Direction.EAST,robot);
        Assert.assertEquals(robot.getDirection(),Direction.EAST);
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

    }
}
