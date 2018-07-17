package com.codurance.katas.map.directions;

import com.codurance.katas.Direction;
import com.codurance.katas.Rover;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class BlockedDirection implements Direction {
    private final String command = "O";

    @Override
    public Direction left() {
        return this;
    }

    @Override
    public Direction right() {
        return this;
    }

    @Override
    public void moveForward(Rover rover) {
    }

    @Override
    public String toCommand() {
        return command;
    }
}