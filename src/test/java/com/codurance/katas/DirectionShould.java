package com.codurance.katas;

import com.codurance.katas.directions.*;
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

        Direction newDirection = startDirection.left();

        assertThat(newDirection, is(equalTo(expectedFinalDirection)));
    }

    @Test
    @Parameters(method = "getExpectedRightDirection")
    public void turn_right(Direction startDirection, Direction expectedFinalDirection) {

        Direction newDirection = startDirection.right();

        assertThat(newDirection, is(equalTo(expectedFinalDirection)));
    }

    @Test
    public void stopped_at_obstacle() {
        Direction blockedDirection = new BlockedDirection();

        Rover rover = new Rover(new Grid(5,5), 1,1, blockedDirection);
        blockedDirection.moveForward(rover);

        assertThat(blockedDirection.left(), is(equalTo(new BlockedDirection())));
        assertThat(blockedDirection.right(), is(equalTo(new BlockedDirection())));
        assertThat(rover, is(equalTo(new Rover(new Grid(5,5), 1,1, blockedDirection))));

    }

    public Object[][] getExpectedLeftDirection(){
        return new Object[][]{
                new Object[]{new NorthDirection(), new WestDirection()},
                new Object[]{new WestDirection(), new SouthDirection()},
                new Object[]{new SouthDirection(), new EastDirection()},
                new Object[]{new EastDirection(), new NorthDirection()}
        };
    }

    public Object[][] getExpectedRightDirection(){
        return new Object[][]{
                new Object[]{new NorthDirection(), new EastDirection()},
                new Object[]{new EastDirection(), new SouthDirection()},
                new Object[]{new SouthDirection(), new WestDirection()},
                new Object[]{new WestDirection(), new NorthDirection()}
        };

    }
}