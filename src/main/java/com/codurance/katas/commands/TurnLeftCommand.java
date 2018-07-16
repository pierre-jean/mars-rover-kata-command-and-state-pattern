package com.codurance.katas.commands;

import com.codurance.katas.Rover;
import com.codurance.katas.Command;

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
