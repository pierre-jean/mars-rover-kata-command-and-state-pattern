package com.codurance.katas.marsrover.map.directions;

import com.codurance.katas.marsrover.Direction;
import com.codurance.katas.marsrover.Rover;
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
        rover.moveWest();
    }

    @Override
    public String toCommand() {
        return command;
    }

}
