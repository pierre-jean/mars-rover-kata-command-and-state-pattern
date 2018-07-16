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

    @Test
    @Parameters(method = "getScenarios")
    public void return_the_right_output(String input, List<String> output) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        PrintStream outputStream = mock(PrintStream.class);
        System.setIn(inputStream);
        System.setOut(outputStream);

        MarsRoverApp app = new MarsRoverApp();
        app.execute();

        output.forEach(line -> verify(outputStream).println(line));
    }

    public Object[][] getScenarios() {
        return new Object[][]{
                new Object[]{
                        createInputFor("5 5", "1 2 N", "LMLMLMLMM"),
                        createOutputFor("1 3 N")
                },
                new Object[]{
                        createInputFor("5 5", "1 1 N", "M"),
                        createOutputFor("1 2 N")
                },
                new Object[]{
                        createInputFor("5 5", "1 1 N", "MM"),
                        createOutputFor("1 3 N")
                },
                new Object[]{
                        createInputFor("5 5","1 1 N", "LLMM"),
                        createOutputFor("1 5 S")
                },
                new Object[]{
                        createInputFor("5 5", "1 5 N", "M"),
                        createOutputFor("1 0 N")
                }
        };
    }


    private Object createOutputFor(String... results) {
        return Arrays.asList(results);
    }

    private Object createInputFor(String... commands) {
        return String.join("\r", commands);
    }
}
