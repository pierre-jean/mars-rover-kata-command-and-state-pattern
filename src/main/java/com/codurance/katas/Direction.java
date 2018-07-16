package com.codurance.katas;

public interface Direction {

    Direction left();
    Direction right();
    void moveForward(Rover rover);

    String toCommand();
}
