package com.codurance.katas.marsrover.commands;

import com.codurance.katas.marsrover.Rover;
import com.codurance.katas.marsrover.Command;

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
