package com.codurance.katas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    private Grid grid;

    @Before
    public void initGrid(){
        grid = new Grid(5, 5);
    }

    @Test
    @Parameters(method = "getPositions")
    public void should_print_correctly(Rover rover, String expectedSituation) {
        assertThat(rover.printSituation(), is(equalTo(expectedSituation)));
        assertThat(rover.printSituation(), is(equalTo(expectedSituation)));

    }

    @Test
    @Parameters(method = "getCommands")
    public void should_apply_command(List<Command> commands, String expectedSituation) {
        Rover rover = new Rover(grid, 1, 1, Direction.NORTH);
        commands.stream().forEach(rover::apply);
        assertThat(rover.printSituation(), is(equalTo(expectedSituation)));
    }

    public Object[][] getPositions() {
        return new Object[][]{
                new Object[]{
                        new Rover(grid, 1, 1, Direction.NORTH), "1 1 N"
                },
                new Object[]{
                        new Rover(grid, 1, 2, Direction.EAST), "1 2 E"
                },
                new Object[]{
                        new Rover(grid, 3, 1, Direction.SOUTH), "3 1 S"
                },
                new Object[]{
                        new Rover(grid, 2, 2, Direction.WEST), "2 2 W"
                }
        };
    }

    public Object[][] getCommands() {
        return new Object[][]{
                new Object[]{
                        Arrays.asList(Command.MOVE_FORWARD), "1 2 N"
                },
                new Object[]{
                        Arrays.asList(Command.MOVE_FORWARD, Command.MOVE_FORWARD), "1 3 N"
                },
                new Object[]{
                        Arrays.asList(Command.TURN_LEFT), "1 1 W"
                },
                new Object[]{
                        Arrays.asList(Command.TURN_LEFT, Command.MOVE_FORWARD), "0 1 W"
                },
                new Object[]{
                        Arrays.asList(Command.TURN_RIGHT, Command.MOVE_FORWARD), "2 1 E"
                },
                new Object[]{
                        Arrays.asList(Command.TURN_RIGHT, Command.TURN_RIGHT, Command.MOVE_FORWARD), "1 0 S"
                }
        };
    }

}
