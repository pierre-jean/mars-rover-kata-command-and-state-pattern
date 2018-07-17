package com.codurance.katas;

import com.codurance.katas.map.directions.BlockedDirection;
import com.codurance.katas.map.Coordinates;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collections;
import java.util.Set;

@ToString
@EqualsAndHashCode
public class Rover {
    @EqualsAndHashCode.Exclude private final Set<Rover> roversDeployed;
    private Coordinates coordinates;
    private Direction direction;

    public Rover(Coordinates coordinates, Direction direction) {
        this(coordinates, direction, Collections.emptySet());
    }

    public Rover(Coordinates coordinates, Direction direction, Set<Rover> roversDeployed) {
        this.roversDeployed = roversDeployed;
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public void moveForward() {
        direction.moveForward(this);
    }

    public void turnRight() {
        this.direction = direction.right();
    }

    public void turnLeft() {
        this.direction = direction.left();
    }

    public void moveNorth() {
        validate(coordinates.getNorth());
    }

    public void moveEast() {
        validate(coordinates.getEast());
    }

    public void moveSouth() {
        validate(coordinates.getSouth());
    }

    public void moveWest() {
        validate(coordinates.getWest());
    }

    public void printSituation() {
        if (!direction.equals(new BlockedDirection())) {
            System.out.println(String.format("%s %s", coordinates.toCommand(), direction.toCommand()));
        }
    }

    private void validate(Coordinates newPosition) {
        if (isLocationOccupiedAt(newPosition)) {
            block(newPosition);
        } else {
            this.coordinates = newPosition;
        }
    }

    private boolean isLocationOccupiedAt(Coordinates coordinates) {
        return roversDeployed.stream().anyMatch(r -> r.coordinates.equals(coordinates));
    }

    private void block(Coordinates coordinates) {
        System.out.println(String.format("O %s %s", coordinates.toCommand(), direction.toCommand()));
        this.direction = new BlockedDirection();
    }

}
