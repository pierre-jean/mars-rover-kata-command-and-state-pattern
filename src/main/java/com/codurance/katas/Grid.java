package com.codurance.katas;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
@EqualsAndHashCode
public class Grid {
    private final int gridXSize;
    private final int gridYSize;
    private Set<Rover> rovers = new HashSet<>();


    public Grid(int xTopRightCorner, int yTopRightCorner) {
        this.gridXSize = xTopRightCorner + 1;
        this.gridYSize = yTopRightCorner + 1;
    }

    public void addRover(Rover rover){
        rovers.add(rover);
    }

    public int getY(int y) {
        return wrap(y, gridYSize);
    }

    public int getX(int x){
        return wrap(x, gridXSize);
    }

    private int wrap(int coordinate, int axisSize) {
        if (coordinate < 0){
            return axisSize + coordinate;
        }
        if (coordinate >= axisSize){
            return coordinate - axisSize;
        }
        return coordinate;
    }

    public boolean isBlocked(int x, int y) {
        return rovers.stream().anyMatch(r -> r.getX() == x && r.getY() == y);
    }
}
