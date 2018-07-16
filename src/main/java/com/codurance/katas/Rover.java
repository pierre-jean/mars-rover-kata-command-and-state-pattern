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
        this.setX(x);
        this.setY(y);
        this.setDirection(direction);
    }


    public String printSituation() {
        return String.format("%d %d %s", getX(), getY(), getDirection().toCommand());
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Grid getGrid() {
        return grid;
    }
}
