package com.codurance.katas.marsrover;

import com.codurance.katas.marsrover.map.Coordinates;

public interface Direction {

    Direction left();
    Direction right();
    void moveForward(Rover rover);
    String toCommand();
    default void printSituationAt(Coordinates coordinates){
        System.out.println(String.format("%s %s", coordinates.toCommand(), toCommand()));
    }
}
