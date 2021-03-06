package com.codurance.katas.marsrover.controller;

import com.codurance.katas.marsrover.Command;
import com.codurance.katas.marsrover.Direction;
import com.codurance.katas.marsrover.Rover;
import com.codurance.katas.marsrover.commands.MoveForwardCommand;
import com.codurance.katas.marsrover.commands.TurnLeftCommand;
import com.codurance.katas.marsrover.commands.TurnRightCommand;
import com.codurance.katas.marsrover.map.Coordinates;
import com.codurance.katas.marsrover.map.Position;
import com.codurance.katas.marsrover.map.directions.EastDirection;
import com.codurance.katas.marsrover.map.directions.NorthDirection;
import com.codurance.katas.marsrover.map.directions.SouthDirection;
import com.codurance.katas.marsrover.map.directions.WestDirection;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleParser {

    private final Scanner scanner;
    private final Map<Rover, List<Command>> roversInstructions = new HashMap<>();

    ConsoleParser(Scanner scanner) {
        this.scanner = scanner;
        parseInput();
    }

    public Map<Rover, List<Command>> getInstructions() {
        return roversInstructions;
    }

    private void parseInput() {
        parseRoversInstructions(parseMapCorner(scanner.nextLine()), new HashSet<>());
    }

    private void parseRoversInstructions(Position mapCorner, Set<Rover> roversDeployed) {
        while (scanner.hasNextLine()) {
            parseRoverInstructions(mapCorner, roversDeployed);
        }
    }

    private void parseRoverInstructions(Position cornerOfMap, Set<Rover> roversDeployed) {
        Rover rover = parseRover(scanner.nextLine(), cornerOfMap, roversDeployed);
        List<Command> commandList = parseCommands(scanner.nextLine(), rover);
        roversDeployed.add(rover);
        roversInstructions.put(rover, commandList);
    }

    private List<Command> parseCommands(String roverCommands, Rover rover) {
        return Arrays.stream(roverCommands.split(""))
                .map(c -> parseCommand(c, rover))
                .collect(Collectors.toList());
    }

    private Command parseCommand(String command, Rover rover) {
        switch (command) {
            case "M":
                return new MoveForwardCommand(rover);
            case "L":
                return new TurnLeftCommand(rover);
            case "R":
                return new TurnRightCommand(rover);
        }
        throw new UnsupportedOperationException(String.format("%s is not recognized as a command", command));
    }

    private Position parseMapCorner(String line) {
        Scanner scanner = new Scanner(line);
        return new Position(scanner.nextInt(), scanner.nextInt());
    }

    private Rover parseRover(String roverPosition, Position mapCorner, Set<Rover> roversDeployed) {
        Scanner scanner = new Scanner(roverPosition);
        Position position = parsePosition(scanner.nextInt(), scanner.nextInt());
        Coordinates coordinates = new Coordinates(position, mapCorner);
        Direction direction = parseDirection(scanner.next());
        return new Rover(coordinates, direction, roversDeployed);
    }

    private Position parsePosition(int x, int y) {
        return new Position(x, y);
    }

    private Direction parseDirection(String directionCommand) {
        if ("N".equals(directionCommand)) {
            return new NorthDirection();
        }
        if ("S".equals(directionCommand)) {
            return new SouthDirection();
        }
        if ("E".equals(directionCommand)) {
            return new EastDirection();
        }
        if ("W".equals(directionCommand)) {
            return new WestDirection();
        }
        throw new UnsupportedOperationException(String.format("%s is not recognized as a Direction", directionCommand));
    }
}
