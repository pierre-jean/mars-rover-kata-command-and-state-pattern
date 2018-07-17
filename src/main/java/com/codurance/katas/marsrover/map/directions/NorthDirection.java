package com.codurance.katas.marsrover.map.directions;

import com.codurance.katas.marsrover.Direction;
import com.codurance.katas.marsrover.Rover;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class NorthDirection implements Direction {
    private final String command = "N";

    @Override
    public Direction left() {
       return new WestDirection();
    }

    @Override
    public Direction right() {
       return new EastDirection();
    }

    @Override
    public void moveForward(Rover rover) {
        rover.moveNorth();
    }

    @Override
    public String toCommand() {
        return command;
    }

}
