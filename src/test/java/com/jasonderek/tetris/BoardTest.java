package com.jasonderek.tetris;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by jasonyoon on 9/26/15.
 */

public class BoardTest {

    private Board board;

    @Test
    public void shouldTriggerActionPerformedAccordingToSpecifiedDelay() throws InterruptedException {
        // GIVEN
        board = new Board(new JLabel());
        Board spyBoard = spy(board);

        // Timer goes off every ms
        Timer timer = new Timer(1, spyBoard);

        // WHEN
        timer.start();
        // Give thread enough time for the timer to go off
        Thread.sleep(70);

        // THEN
        verify(spyBoard, atLeastOnce()).actionPerformed(any(ActionEvent.class));
    }

    @Test
    public void canSetTimerWithSetter() {
        // GIVEN
        board = new Board(new JLabel());
        Timer expectedTimer = new Timer(1, board);

        // WHEN
        board.setTimer(expectedTimer);

        // THEN
        Timer actualTimer = board.getTimer();
        Assert.assertEquals(expectedTimer, actualTimer);
    }

}
