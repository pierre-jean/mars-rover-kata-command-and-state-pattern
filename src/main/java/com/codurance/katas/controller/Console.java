package com.codurance.katas.controller;

import com.codurance.katas.Command;
import com.codurance.katas.Direction;
import com.codurance.katas.Grid;
import com.codurance.katas.Rover;
import com.codurance.katas.commands.MoveForwardCommand;
import com.codurance.katas.commands.TurnLeftCommand;
import com.codurance.katas.commands.TurnRightCommand;
import com.codurance.katas.directions.EastDirection;
import com.codurance.katas.directions.NorthDirection;
import com.codurance.katas.directions.SouthDirection;
import com.codurance.katas.directions.WestDirection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Console {


    public static Grid parseGrid(String gridSize) {
        Scanner scanner = new Scanner(gridSize);
        int x= scanner.nextInt();
        int y= scanner.nextInt();
        return new Grid(x, y);
    }

    public static Rover parseRover(String roverPosition, Grid grid) {
        Scanner scanner = new Scanner(roverPosition);
        return new Rover(grid,scanner.nextInt(), scanner.nextInt(), parseDirection(scanner.next()));
    }

    public static List<Command> parseCommands(String roverCommands, Rover rover) {
        return Arrays.stream(roverCommands.split(""))
                .map(c -> parseCommand(c, rover))
                .collect(Collectors.toList());
    }

    private static Direction parseDirection(String directionCommand) {
        if ("N".equals(directionCommand)){
            return new NorthDirection();
        }
        if ("S".equals(directionCommand)){
            return new SouthDirection();
        }
        if ("E".equals(directionCommand)){
            return new EastDirection();
        }
        return new WestDirection();

    }

    private static Command parseCommand(String command, Rover rover) {
        switch(command){
            case "M":
                return new MoveForwardCommand(rover);
            case "L":
                return new TurnLeftCommand(rover);
            case "R":
                return new TurnRightCommand(rover);
        }
        return null;
    }

}
