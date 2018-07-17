package com.codurance.katas.map.directions;

import com.codurance.katas.Direction;
import com.codurance.katas.Rover;
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
        rover.moveEast();
    }

    @Override
    public String toCommand() {
        return command;
    }
}
