package com.codurance.katas;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Rover {
    private int x;
    private int y;
    private Direction direction;
    private Grid grid;


    public Rover(Grid grid, int x, int y, Direction direction) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void moveForward(){
       direction.moveForward(this);
    }


    public void turnRight() {
        this.direction = direction.right();
    }

    public void turnLeft() {
        this.direction = direction.left();
    }

    public String printSituation() {
        return String.format("%d %d %s", getX(), getY(), direction.toCommand());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Grid getGrid() {
        return grid;
    }

}
