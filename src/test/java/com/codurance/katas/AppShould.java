package com.codurance.katas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(JUnitParamsRunner.class)
public class AppShould {

    @Test
    @Parameters(method = "getScenarios")
    public void return_the_right_output(String input, List<String> output) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        PrintStream outputStream = mock(PrintStream.class);
        System.setIn(inputStream);
        System.setOut(outputStream);
        App app = new App();

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
                        createOutputFor("1 4 S")
                },
                new Object[]{
                        createInputFor("5 5", "1 5 N", "M"),
                        createOutputFor("1 1 N")
                },
                new Object[]{
                        createInputFor("5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM"),
                        createOutputFor("1 3 N", "5 1 E")
                },
                new Object[]{
                        createInputFor("5 5","1 1 N", "LLLL", "1 0 N", "MMMM"),
                        createOutputFor("1 1 N", "O 1 1 N")
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
