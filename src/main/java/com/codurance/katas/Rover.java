package com.codurance.katas;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Rover {
    private int x;
    private int y;
    private Direction direction;
    private Grid grid;


    Rover(Grid grid, int x, int y, Direction direction) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void apply(Command command){
        direction = direction.newDirection(command);
        if (command.equals(Command.MOVE_FORWARD)){
            switch (direction){
                case NORTH:
                    y = grid.getY(y+1);
                    break;
                case WEST:
                    x = grid.getX( x-1);
                    break;
                case EAST:
                    x = grid.getX(x+1);
                    break;
                case SOUTH:
                    y = grid.getY(y-1);
                    break;
            }
        }
    }


    public String printSituation() {
        return String.format("%d %d %s", x, y, direction.toCommand());
    }

}
