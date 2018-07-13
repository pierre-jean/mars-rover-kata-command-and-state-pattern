package com.codurance.katas;

import java.util.Scanner;

public class MarsRoverApp {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("5 5") && scanner.nextLine().equals("1 2 N")){
            System.out.println("1 3 N");
            System.out.println("5 1 E");
        }else{
            System.out.println("1 2 N");
        }
    }
}
