package com.codurance.katas;

import com.codurance.katas.controller.ConsoleController;

public class App {

    public void execute() {
        ConsoleController consoleController =  new ConsoleController(System.in);
        consoleController.execute();
    }
}
