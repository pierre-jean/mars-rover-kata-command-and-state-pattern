package com.codurance.katas.marsrover.map;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Coordinates {
    private final Position position;
    private final Position cornerOfTheMap;

    public Coordinates(Position position, Position cornerOfTheMap) {
        this.position = position;
        this.cornerOfTheMap = cornerOfTheMap;
    }

    public Coordinates getEast() {
        return wrap(this.position.getEast());
    }


    public Coordinates getNorth() {
        return wrap(this.position.getNorth());
    }

    public Coordinates getWest() {
        return wrap(this.position.getWest());
    }

    public Coordinates getSouth() {
        return wrap(this.position.getSouth());
    }

    public String toCommand() {
        return String.format("%s", position.toCommand());
    }

    private Coordinates wrap(Position position) {
        Position wrappedPosition = position.wrapWithinLimitOf(cornerOfTheMap);
        return new Coordinates(wrappedPosition, cornerOfTheMap);
    }
}
