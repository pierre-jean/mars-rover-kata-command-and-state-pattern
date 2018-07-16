package com.codurance.katas;

import com.codurance.katas.directions.BlockedDirection;
import lombok.ToString;

import java.util.Objects;

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
        if (direction.equals(new BlockedDirection())){
            return "";
        }
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

    public void block(int blockedX, int blockedY) {
        System.out.println(String.format("O %d %d %s", blockedX, blockedY, direction.toCommand()));
        this.direction = new BlockedDirection();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return x == rover.x &&
                y == rover.y &&
                Objects.equals(direction, rover.direction);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, direction);
    }
}
