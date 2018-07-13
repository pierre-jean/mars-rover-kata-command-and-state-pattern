package com.codurance.katas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnitParamsRunner.class)
public class MarsRoverShould {

    public static final String INPUT = String.join("\r",
            "5 5",
            "1 2 N",
            "LMLMLMLMM",
            "3 3 E",
            "MMRMMRMRRM");

    @Test
    @Parameters(method = "getScenarios")
    public void return_the_right_output(String input, List<String> output) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        PrintStream outputStream = mock(PrintStream.class);
        System.setIn(inputStream);
        System.setOut(outputStream);

        MarsRoverApp app = new MarsRoverApp();
        app.execute();

        output.stream().forEach( line -> verify( outputStream).println(line));
    }

    Object[][] getScenarios(){
       return new Object[][]{
               new Object[]{
                       createInputFor("5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM"),
                       createOutputFor("1 3 N", "5 1 E")
               }
       };
    }


    private Object createOutputFor(String... results){
        return Arrays.asList(results);
    }

    private Object createInputFor(String... commands){
        return String.join("\r", commands);
    }
}
