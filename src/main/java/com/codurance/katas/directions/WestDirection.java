package com.codurance.katas.directions;

import com.codurance.katas.Rover;
import com.codurance.katas.Direction;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class WestDirection implements Direction {
    private final String command = "W";

    @Override
    public Direction left() {
        return new SouthDirection();
    }

    @Override
    public Direction right() {
        return new NorthDirection();
    }

    @Override
    public void moveForward(Rover rover) {
        int newX = rover.getGrid().getX(rover.getX() -1);
        rover.setX(newX);
    }

    @Override
    public String toCommand() {
        return command;
    }
}
