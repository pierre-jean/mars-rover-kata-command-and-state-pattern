package com.codurance.katas.marsrover.map.directions;

import com.codurance.katas.marsrover.Direction;
import com.codurance.katas.marsrover.Rover;
import com.codurance.katas.marsrover.map.Coordinates;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class BlockedDirection implements Direction {
    private final String command = "O";
    private final Direction previousDirection;
    private final Coordinates obstacleCoordinates;

    public BlockedDirection(Direction previousDirection, Coordinates obstacleCoordinates) {
        this.previousDirection = previousDirection;
        this.obstacleCoordinates = obstacleCoordinates;
    }

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

    @Override
    public void printSituationAt(Coordinates coordinates) {
        System.out.println(String.format("%s %s %s", command, this.obstacleCoordinates.toCommand(), previousDirection.toCommand()));
    }
}
