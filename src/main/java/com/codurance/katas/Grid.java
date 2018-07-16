package com.codurance.katas;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Grid {
    private final int gridXSize;
    private final int gridYSize;


    public Grid(int xTopRightCorner, int yTopRightCorner) {
        this.gridXSize = xTopRightCorner + 1;
        this.gridYSize = yTopRightCorner + 1;
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
}
