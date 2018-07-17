package com.codurance.katas.marsrover;

import com.codurance.katas.marsrover.map.Coordinates;
import com.codurance.katas.marsrover.map.Position;
import com.codurance.katas.marsrover.map.directions.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class DirectionShould {

    private final Direction directionBeforeBlock = new NorthDirection();
    private final Coordinates obstacleCoordinates = new Coordinates(new Position(2,2), new Position(5,5));
    private final Direction blockedDirection = new BlockedDirection(directionBeforeBlock, obstacleCoordinates);

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
        Rover rover = mock(Rover.class);

        blockedDirection.moveForward(rover);

        verify(rover, never()).moveEast();
        verify(rover, never()).moveWest();
        verify(rover, never()).moveSouth();
        verify(rover, never()).moveNorth();
    }

    public Object[][] getExpectedLeftDirection(){
        return new Object[][]{
                new Object[]{new NorthDirection(), new WestDirection()},
                new Object[]{new WestDirection(), new SouthDirection()},
                new Object[]{new SouthDirection(), new EastDirection()},
                new Object[]{new EastDirection(), new NorthDirection()},
                new Object[]{blockedDirection, blockedDirection}
        };
    }

    public Object[][] getExpectedRightDirection(){
        return new Object[][]{
                new Object[]{new NorthDirection(), new EastDirection()},
                new Object[]{new EastDirection(), new SouthDirection()},
                new Object[]{new SouthDirection(), new WestDirection()},
                new Object[]{new WestDirection(), new NorthDirection()},
                new Object[]{blockedDirection, blockedDirection}
        };

    }
}