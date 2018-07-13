package com.codurance.katas;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MarsRoverShould {

    public static final String INPUT = String.join("\r",
            "5 5",
            "1 2 N",
            "LMLMLMLMM",
            "3 3 E",
            "MMRMMRMRRM");

    @Test
    public void return_the_right_output() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(INPUT.getBytes());
        PrintStream outputStream = mock(PrintStream.class);
        System.setIn(inputStream);
        System.setOut(outputStream);

        MarsRoverApp app = new MarsRoverApp();
        app.execute();

        verify(outputStream).println("1 3 N");
        verify(outputStream).println("5 1 E");
    }
}
