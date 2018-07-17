package com.codurance.katas.marsrover;

public interface Direction {

    Direction left();
    Direction right();
    void moveForward(Rover rover);
    String toCommand();
}
