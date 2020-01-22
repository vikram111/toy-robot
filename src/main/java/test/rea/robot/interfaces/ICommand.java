package test.rea.robot.interfaces;

import test.rea.robot.enums.Command;
import test.rea.robot.enums.Direction;
import test.rea.robot.exceptions.InvalidPositionException;
import test.rea.robot.exceptions.RobotException;
import test.rea.robot.models.Robot;

/**
 * Interface to supplement changes to method implementations like changing the implementation for a move to move
 * 2 places instead of 1 etc.
 */
public interface ICommand {
    void executePlace(Integer x, Integer y , Direction direction, Robot robot) throws InvalidPositionException;
    void turnLeft(Robot robot);
    void turnRight(Robot robot);
    void executeMove(Robot robot) throws RobotException;
    void executeCommand(Command command, Robot robot);

}
