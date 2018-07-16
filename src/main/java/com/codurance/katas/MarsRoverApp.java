package com.codurance.katas;

import com.codurance.katas.controller.Console;

import java.util.List;
import java.util.Scanner;

public class MarsRoverApp {

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Grid grid = Console.parseGrid(scanner.nextLine());
        while(scanner.hasNextLine()){
            executeRoverCommands(scanner, grid);
        }
    }

    private void executeRoverCommands(Scanner scanner, Grid grid) {
        Rover rover = Console.parseRover(scanner.nextLine(), grid);
        grid.addRover(rover);
        List<Command> commandList = Console.parseCommands(scanner.nextLine(), rover);
        commandList.forEach(Command::execute);

        System.out.println(rover.printSituation());
    }

}
