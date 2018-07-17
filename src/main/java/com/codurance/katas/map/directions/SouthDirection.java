package com.codurance.katas.map.directions;

import com.codurance.katas.Direction;
import com.codurance.katas.Rover;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class SouthDirection implements Direction {
    private final String command = "S";

    @Override
    public Direction left() {
        return new EastDirection();
    }

    @Override
    public Direction right() {
        return new WestDirection();
    }

    @Override
    public void moveForward(Rover rover) {
        rover.moveSouth();
    }

    @Override
    public String toCommand() {
        return command;
    }

}
