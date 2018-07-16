package com.codurance.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MarsRoverApp {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String gridSize = scanner.nextLine();
        String roverPosition = scanner.nextLine();
        String roverCommand = scanner.nextLine();
        List<String> events = getRoverLog(gridSize, roverPosition, roverCommand);
        for (String result : events){
            System.out.println(result);
        }
    }

    private List<String> getRoverLog(String gridSize, String roverPosition, String roverCommands) {
        List<String> event = new ArrayList<>();
        Grid grid = buildGridFrom(gridSize);
        Rover rover = buildRoverFrom(roverPosition, grid);
        List<Command> commands = buildCommandFrom(roverCommands);
        commands.stream().forEach(c -> c.applyCommandOn(rover.getDirection(), rover, rover.getGrid()));
        System.out.println(rover.printSituation());
        return event;
    }

    private List<Command> buildCommandFrom(String roverCommands) {
        return Arrays.asList(roverCommands.split("")).stream().map( c -> parse(c)).collect(Collectors.toList());
    }

    private Command parse(String command) {
        switch(command){
            case "M":
                return Command.MOVE_FORWARD;
            case "L":
                return Command.TURN_LEFT;
            case "R":
                return Command.TURN_RIGHT;
        }
        return null;
    }

    private Grid buildGridFrom(String gridSize) {
        Scanner scanner = new Scanner(gridSize);
        int x= scanner.nextInt();
        int y= scanner.nextInt();
        return new Grid(x, y);
    }

    private Rover buildRoverFrom(String roverPosition, Grid grid) {
        Scanner scanner = new Scanner(roverPosition);
        return new Rover(grid,scanner.nextInt(), scanner.nextInt(), Direction.fromCommand(scanner.next()));
    }
}
