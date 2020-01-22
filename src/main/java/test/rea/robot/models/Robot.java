package test.rea.robot.models;

import java.lang.String;
import lombok.*;
import test.rea.robot.enums.Direction;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Robot {
    private static final int X_MAX = 5;
    private static final int Y_MAX = 5;
    private Integer x;
    private Integer y;
    private Direction direction;
    private Boolean isPlacedOnTable;

    public Robot(Boolean isPlacedOnTable){
        this.isPlacedOnTable = isPlacedOnTable;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append(this.x);
        stringBuilder.append(",");
        stringBuilder.append(this.y);
        stringBuilder.append(",");
        stringBuilder.append(this.direction);
        return stringBuilder.toString();
    }
}

