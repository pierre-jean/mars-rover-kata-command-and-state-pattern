package com.codurance.katas.commands;

import com.codurance.katas.Rover;
import com.codurance.katas.Command;

public class TurnRightCommand implements Command {
    private final Rover rover;

    public TurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnRight();
    }
}
