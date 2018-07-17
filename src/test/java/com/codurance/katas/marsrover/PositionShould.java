package com.codurance.katas.marsrover;

import com.codurance.katas.marsrover.map.Position;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PositionShould {

    @Test
    @Parameters(method = "getRemapPositions")
    public void wrap_position_according_to_corner(Position initialPosition, Position corner, Position remapPosition){
        assertThat(initialPosition.wrapWithinLimitOf(corner), is(equalTo(remapPosition)));
    }

    public Object[][] getRemapPositions(){
        return new Object[][]{
                new Object[]{
                        new Position(5,5), new Position(5,5), new Position(5,5)
                },
                new Object[]{
                        new Position(4,4), new Position(5,5), new Position(4,4)
                },
                new Object[]{
                        new Position(5,5), new Position(4,4), new Position(1,1)
                },
                new Object[]{
                        new Position(-1,2), new Position(4,4), new Position(3,2)
                },
                new Object[]{
                        new Position(5,-2), new Position(4,4), new Position(1, 2)
                }
        };
    }
}