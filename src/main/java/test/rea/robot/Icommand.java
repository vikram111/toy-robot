package test.rea.robot;

import test.rea.robot.models.Robot;

public interface Icommand {
    void executePlace(Integer x, Integer y , Direction direction, Robot robot);
    void turnLeft(Robot robot);
    void turnRight(Robot robot);
    Robot executeMove(Robot robot);

}
