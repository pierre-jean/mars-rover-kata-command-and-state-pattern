package com.codurance.katas.controller;

import com.codurance.katas.Command;
import com.codurance.katas.Rover;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class ConsoleController {
    private final Scanner scanner;

    public ConsoleController(InputStream in) {
        scanner = new Scanner(in);
    }

    public void execute() {
        Map<Rover, List<Command>> roversInstructions = new ConsoleParser(scanner).getInstructions();
        roversInstructions.forEach(this::executeRoverInstructions);
    }

    private void executeRoverInstructions(Rover rover, List<Command> commandList) {
        commandList.forEach(Command::execute);
        rover.printSituation();
    }
}
