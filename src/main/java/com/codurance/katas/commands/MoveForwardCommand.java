package com.codurance.katas.commands;

import com.codurance.katas.Command;
import com.codurance.katas.Rover;

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
