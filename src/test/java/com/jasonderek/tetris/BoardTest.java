package com.jasonderek.tetris;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by jasonyoon on 9/26/15.
 */

public class BoardTest {

    private Board board;

    @Before
    public void setup() {
        board = new Board(new JLabel());
    }

    @Test
    public void shouldTriggerActionPerformedAccordingToSpecifiedDelay() throws InterruptedException {
        // GIVEN
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
        Timer expectedTimer = new Timer(1, board);

        // WHEN
        board.setTimer(expectedTimer);

        // THEN
        Timer actualTimer = board.getTimer();
        Assert.assertEquals(expectedTimer, actualTimer);
    }

    @Test
    public void TimerShouldStartWhenBoardStarts() {
        // GIVEN
        Timer timer = new Timer(1, board);
        Timer spyTimer = spy(timer);
        board.setTimer(spyTimer);

        // WHEN
        board.start();

        // THEN
        verify(spyTimer, times(1)).start();
    }

}
