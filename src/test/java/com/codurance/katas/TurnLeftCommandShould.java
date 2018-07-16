package com.codurance.katas;

import com.codurance.katas.commands.TurnLeftCommand;
import com.codurance.katas.directions.EastDirection;
import com.codurance.katas.directions.NorthDirection;
import com.codurance.katas.directions.SouthDirection;
import com.codurance.katas.directions.WestDirection;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class TurnLeftCommandShould {

    private final Grid grid = new Grid(5, 5);

    @Test
    @Parameters(method = "getRoverToTurnLeft")
    public void turn_rover_left(Rover rover, Rover expectedRover) {
        TurnLeftCommand turnLeftCommand = new TurnLeftCommand(rover);

        turnLeftCommand.execute();

        assertThat(rover, is(equalTo(expectedRover)));

    }

    public Object[][] getRoverToTurnLeft() {
        return new Object[][]{
                new Object[]{
                        new Rover(grid, 1, 1, new WestDirection()),
                        new Rover(grid, 1, 1, new SouthDirection())
                },
                new Object[]{
                        new Rover(grid, 1, 1, new SouthDirection()),
                        new Rover(grid, 1,1 , new EastDirection())
                },
                new Object[]{
                        new Rover(grid, 1, 1, new EastDirection()),
                        new Rover(grid, 1, 1, new NorthDirection())
                },
                new Object[]{
                        new Rover(grid, 1, 1, new NorthDirection()),
                        new Rover(grid, 1, 1, new WestDirection())
                }
        };
    }
}