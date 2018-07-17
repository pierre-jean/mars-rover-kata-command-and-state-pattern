package com.codurance.katas.marsrover.commands;

import com.codurance.katas.marsrover.Rover;
import com.codurance.katas.marsrover.Command;

public class TurnLeftCommand implements Command {
    private final Rover rover;

    public TurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnLeft();
    }
}
