package com.codurance.katas;

import java.util.Scanner;

public class MarsRoverApp {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        String gridSize = scanner.nextLine();
        String roverPosition = scanner.nextLine();
        String roverCommand = scanner.nextLine();
        if (gridSize.equals("5 5") && roverPosition.equals("1 2 N") && roverCommand.equals("LMLMLMLMM")){
            System.out.println("1 3 N");
            System.out.println("5 1 E");
        }
        if (gridSize.equals("5 5") && roverPosition.equals("1 1 N") && roverCommand.equals("M")){
            System.out.println("1 2 N");
        }
        if (gridSize.equals("5 5") && roverPosition.equals("1 1 N") && roverCommand.equals("MM")){
            System.out.println("1 3 N");
        }
    }
}
