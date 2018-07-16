package com.codurance.katas;

import com.codurance.katas.directions.EastDirection;
import com.codurance.katas.directions.NorthDirection;
import com.codurance.katas.directions.SouthDirection;
import com.codurance.katas.directions.WestDirection;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    private Grid grid;
    private Rover rover;

    @Before
    public void initGrid(){
        grid = new Grid(5, 5);
        rover = new Rover(grid, 1, 1, new NorthDirection());
    }

    @Test
    @Parameters(method = "getPositions")
    public void should_print_correctly(Rover rover, String expectedSituation) {
        assertThat(rover.printSituation(), is(equalTo(expectedSituation)));
        assertThat(rover.printSituation(), is(equalTo(expectedSituation)));

    }

    public Object[][] getPositions() {
        return new Object[][]{
                new Object[]{
                        new Rover(grid, 1, 1, new NorthDirection()), "1 1 N"
                },
                new Object[]{
                        new Rover(grid, 1, 2, new EastDirection()), "1 2 E"
                },
                new Object[]{
                        new Rover(grid, 3, 1, new SouthDirection()), "3 1 S"
                },
                new Object[]{
                        new Rover(grid, 2, 2, new WestDirection()), "2 2 W"
                }
        };
    }

}
