package com.codurance.katas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class DirectionShould {

    @Test
    @Parameters(method = "getExpectedLeftDirection")
    public void turn_left(Direction startDirection, Direction expectedFinalDirection) {
        Direction direction = startDirection;

        Direction newDirection = direction.newDirection(Command.TURN_LEFT);

        assertThat(newDirection, is(equalTo(expectedFinalDirection)));
    }

    @Test
    @Parameters(method = "getExpectedRightDirection")
    public void turn_right(Direction startDirection, Direction expectedFinalDirection) {
        Direction direction = startDirection;

        Direction newDirection = direction.newDirection(Command.TURN_RIGHT);

        assertThat(newDirection, is(equalTo(expectedFinalDirection)));
    }

    public Object[][] getExpectedLeftDirection(){
        return new Object[][]{
                new Object[]{Direction.NORTH, Direction.WEST},
                new Object[]{Direction.WEST, Direction.SOUTH},
                new Object[]{Direction.SOUTH, Direction.EAST},
                new Object[]{Direction.EAST, Direction.NORTH}
        };
    }

    public Object[][] getExpectedRightDirection(){
        return new Object[][]{
                new Object[]{Direction.NORTH, Direction.EAST},
                new Object[]{Direction.EAST, Direction.SOUTH},
                new Object[]{Direction.SOUTH, Direction.WEST},
                new Object[]{Direction.WEST, Direction.NORTH}
        };

    }
}