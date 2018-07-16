package com.codurance.katas;

import com.codurance.katas.commands.MoveForwardCommand;
import com.codurance.katas.directions.EastDirection;
import com.codurance.katas.directions.NorthDirection;
import com.codurance.katas.directions.SouthDirection;
import com.codurance.katas.directions.WestDirection;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class MoveForwardCommandShould {

    private Grid grid = new Grid(5,5);

    @Test
    @Parameters(method = "getRoverMovingForward")
    public void move_rover_in_the_right_direction(Rover rover, Rover expectedRover) {
        Command command = new MoveForwardCommand(rover);

        command.execute();

        assertThat(rover, is(equalTo(expectedRover)));
    }

    public Object[][] getRoverMovingForward(){
        return new Object[][]{
                new Object[]{
                        new Rover(grid, 0,0, new NorthDirection()),
                        new Rover(grid, 0, 1, new NorthDirection())
                },
                new Object[]{
                        new Rover(grid, 1, 0, new SouthDirection()),
                        new Rover(grid, 1, 5, new SouthDirection())
                },
                new Object[]{
                        new Rover(grid, 4,4, new EastDirection()),
                        new Rover(grid, 5, 4, new EastDirection())
                },
                new Object[]{
                        new Rover(grid, 4,4, new WestDirection()),
                        new Rover(grid, 3, 4, new WestDirection())
                }
        };
    }

}