package com.codurance.katas.directions;

import com.codurance.katas.Rover;
import com.codurance.katas.Direction;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class EastDirection implements Direction {
    private final String command = "E";

    @Override
    public Direction left() {
        return new NorthDirection();
    }

    @Override
    public Direction right() {
        return new SouthDirection();
    }

    @Override
    public void moveForward(Rover rover) {
        int newX = rover.getGrid().getX(rover.getX() +1);
        if (rover.getGrid().isBlocked(newX, rover.getY())){
            rover.block(newX, rover.getY());
        } else{
            rover.setX(newX);
        }
    }

    @Override
    public String toCommand() {
        return command;
    }
}
