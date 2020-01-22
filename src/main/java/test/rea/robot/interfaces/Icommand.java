package test.rea.robot.interfaces;

import test.rea.robot.enums.Direction;
import test.rea.robot.exceptions.InvalidPositionException;
import test.rea.robot.exceptions.RobotException;
import test.rea.robot.models.Robot;

public interface Icommand {
    void executePlace(Integer x, Integer y , Direction direction, Robot robot) throws InvalidPositionException;
    void turnLeft(Robot robot);
    void turnRight(Robot robot);
    void executeMove(Robot robot) throws RobotException;

}
