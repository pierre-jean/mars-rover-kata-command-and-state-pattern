package com.codurance.katas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class GridShould {

    @Test
    @Parameters({"0", "1", "2", "3", "4", "5"})
    public void returnSameXForPositionUnderTheGrid(int x) {
        Grid grid = new Grid(5, 5);
        assertThat(grid.getX(x), is(equalTo(x)));
    }

    @Test
    @Parameters({"0", "1", "2", "3", "4", "5"})
    public void returnSameYForPositionUnderTheGrid(int y) {
        Grid grid = new Grid(5, 5);
        assertThat(grid.getY(y), is(equalTo(y)));
    }

    @Test
    @Parameters({"-1, 5", "6, 0", "8, 2"})
    public void wrapXPositionOutsideGrid(int givenX, int expectedX) {
        Grid grid = new Grid(5, 5);
        assertThat(grid.getX(givenX), is(equalTo(expectedX)));
    }

    @Test
    @Parameters({"-1, 5", "6, 0", "8, 2"})
    public void wrapYPositionOutsideGrid(int givenY, int expectedY) {
        Grid grid = new Grid(5, 5);
        assertThat(grid.getY(givenY), is(equalTo(expectedY)));
    }
}