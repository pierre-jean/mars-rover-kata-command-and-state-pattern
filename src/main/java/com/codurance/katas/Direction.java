package com.codurance.katas;

import java.util.Arrays;

public enum Direction {
    NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

    private final String commandTranslation;

    Direction(String commandTranslation) {
        this.commandTranslation = commandTranslation;
    }

    public static Direction fromCommand(String command) {
        return
        Arrays.stream(Direction.values())
                .filter( d -> d.commandTranslation.equals(command))
                .findAny().orElse(Direction.NORTH);
    }

    public Object toCommand() {
        return commandTranslation;
    }

    public Direction newDirection(Command command) {
       if (Command.TURN_LEFT.equals(command)){
           switch (this){
               case EAST:
                   return NORTH;
               case SOUTH:
                   return EAST;
               case WEST:
                   return SOUTH;
               case NORTH:
                   return WEST;
           }
       }
       if (Command.TURN_RIGHT.equals(command)){
           switch(this){
               case NORTH:
                   return EAST;
               case EAST:
                   return SOUTH;
               case SOUTH:
                   return WEST;
               case WEST:
                   return NORTH;
           }
       }
       return this;
    }
}
