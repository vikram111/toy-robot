package test.rea.robot.models;

import lombok.*;
import test.rea.robot.Direction;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Robot {
    private static final int X_MAX = 5;
    private static final int Y_MAX = 5;
    private Integer x;
    private Integer y;
    private Direction direction;
    private Boolean isPlacedOnTable;

}

