package com.codurance.katas.marsrover;

import com.codurance.katas.marsrover.controller.ConsoleController;

public class App {

    public void execute() {
        ConsoleController consoleController =  new ConsoleController(System.in);
        consoleController.execute();
    }
}
