package com.codurance.katas;

import com.codurance.katas.controller.Console;

import java.util.List;
import java.util.Scanner;

public class MarsRoverApp {

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Grid grid = Console.parseGrid(scanner.nextLine());
        Rover rover = Console.parseRover(scanner.nextLine(), grid);
        List<Command> commandList = Console.parseCommands(scanner.nextLine(), rover);

        commandList.forEach(Command::execute);

        System.out.println(rover.printSituation());
    }

}
