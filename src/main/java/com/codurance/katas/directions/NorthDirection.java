package com.codurance.katas.directions;

import com.codurance.katas.Grid;
import com.codurance.katas.Rover;
import com.codurance.katas.Direction;
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
        Grid grid = rover.getGrid();
        int newY = rover.getGrid().getY(rover.getY() + 1);
        if(grid.isBlocked(rover.getX(), newY)){
            rover.block(rover.getX(), newY);
        }else{
            rover.setY(newY);
        }
    }

    @Override
    public String toCommand() {
        return command;
    }
}
