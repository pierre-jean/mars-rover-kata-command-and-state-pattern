package com.codurance.katas.marsrover.commands;

import com.codurance.katas.marsrover.Command;
import com.codurance.katas.marsrover.Rover;

public class MoveForwardCommand implements Command {
    private final Rover rover;

    public MoveForwardCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        this.rover.moveForward();

    }
}
