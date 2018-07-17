package com.codurance.katas.marsrover.map;


import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getNorth() {
        return new Position(x, y + 1);
    }

    public Position getEast() {
        return new Position(x + 1, y);
    }

    public Position getSouth() {
        return new Position(x, y - 1);
    }

    public Position getWest() {
        return new Position(x - 1, y);
    }

    public String toCommand() {
        return String.format("%d %d", x, y);
    }

    public Position wrapWithinLimitOf(Position corner) {
        return new Position(wrapAxis(x, corner.x), wrapAxis(y, corner.y));
    }

    private int wrapAxis(int coordinateToRemap, int axisGridLimit) {
        if (coordinateToRemap > axisGridLimit) {
            coordinateToRemap = coordinateToRemap - axisGridLimit;
        }
        if (coordinateToRemap < 1) {
            coordinateToRemap = axisGridLimit + coordinateToRemap;
        }
        return coordinateToRemap;
    }
}
