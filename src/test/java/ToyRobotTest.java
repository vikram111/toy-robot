import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import test.rea.robot.Command;
import test.rea.robot.ToyRobot;

@Slf4j
public class ToyRobotTest {
    private ToyRobot toyRobot;
    @Before
    public void setup(){
        toyRobot = new ToyRobot();
    }
    @Test
    public void testTableTopDimension(){
        Assert.assertEquals(toyRobot.executeCommand(Command.LEFT),"LEFT");
    }

    @Test
    public void testExecutePlaceCommand(){

    }

    @Test
    public void testExecuteLeftCommand(){

    }

    @Test
    public void testExecuteRightCommand(){

    }

    @Test
    public void testExecuteReportCommand(){

    }

}
