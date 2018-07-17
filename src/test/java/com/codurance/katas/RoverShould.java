package com.codurance.katas;

import com.codurance.katas.map.directions.EastDirection;
import com.codurance.katas.map.directions.NorthDirection;
import com.codurance.katas.map.directions.SouthDirection;
import com.codurance.katas.map.directions.WestDirection;
import com.codurance.katas.map.Coordinates;
import com.codurance.katas.map.Position;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnitParamsRunner.class)
public class RoverShould {


    private final Position cornerOfTheMap = new Position(5, 5);

    @Before
    public void initGrid(){
    }

    @Test
    @Parameters(method = "getPositions")
    public void print_its_situation(Rover rover, String expectedSituation) {
        PrintStream output = mock(PrintStream.class);
        System.setOut(output);

        rover.printSituation();

        verify(output).println(expectedSituation);
    }

    @Test
    @Parameters(method = "getRoverMovingForward")
    public void move_rover_in_the_right_direction(Rover rover, Rover expectedRover) {

        rover.moveForward();

        assertThat(rover, is(equalTo(expectedRover)));
    }

    public Object[][] getPositions() {
        return new Object[][]{
                new Object[]{
                        new Rover(new Coordinates(new Position(1, 1), cornerOfTheMap), new NorthDirection()), "1 1 N"
                },
                new Object[]{
                        new Rover(new Coordinates(new Position(1, 2), cornerOfTheMap), new EastDirection()), "1 2 E"
                },
                new Object[]{
                        new Rover(new Coordinates(new Position(3, 1), cornerOfTheMap), new SouthDirection()), "3 1 S"
                },
                new Object[]{
                        new Rover(new Coordinates(new Position(2, 2), cornerOfTheMap), new WestDirection()), "2 2 W"
                }
        };
    }

    public Object[][] getRoverMovingForward() {
        return new Object[][]{
                new Object[]{
                        new Rover(new Coordinates(new Position(1, 1), cornerOfTheMap), new NorthDirection()),
                        new Rover(new Coordinates(new Position(1, 2), cornerOfTheMap), new NorthDirection())
                },
                new Object[]{
                        new Rover(new Coordinates(new Position(1, 1), cornerOfTheMap), new SouthDirection()),
                        new Rover(new Coordinates(new Position(1, 5), cornerOfTheMap), new SouthDirection())
                },
                new Object[]{
                        new Rover(new Coordinates(new Position(4, 4), cornerOfTheMap), new EastDirection()),
                        new Rover(new Coordinates(new Position(5, 4), cornerOfTheMap), new EastDirection())
                },
                new Object[]{
                        new Rover(new Coordinates(new Position(4, 4), cornerOfTheMap), new WestDirection()),
                        new Rover(new Coordinates(new Position(3, 4), cornerOfTheMap), new WestDirection())
                }
        };
    }

}
