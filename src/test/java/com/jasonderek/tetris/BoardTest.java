package com.jasonderek.tetris;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class BoardTest {

    private Board board;

    @Before
    public void setup() {
        board = new Board(new JLabel());
    }

    @Test
    public void canCallConstructorWithStatusBar() {
        // GIVEN
        JLabel expectedStatusBar = new JLabel("");

        // WHEN
        board = new Board(expectedStatusBar);

        // THEN
        JLabel actualStatusBar = board.getStatusBar();
        Assert.assertEquals(expectedStatusBar, actualStatusBar);
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

    @Test
    public void canGetSquareWidth() {
        // GIVEN
        int panelWidth = 100;
        board.setSize(panelWidth, 200);

        int boardWidth = 5;
        board.setBoardWidth(boardWidth);

        // WHEN
        int actualSquareWidth = board.squareWidth();

        // THEN
        int expectedSquareWidth = panelWidth / boardWidth;
        Assert.assertEquals(expectedSquareWidth, actualSquareWidth);
    }

    @Test
    public void canGetSquareHeight() {
        // GIVEN
        int panelHeight = 100;
        board.setSize(200, panelHeight);

        int boardHeight = 5;
        board.setBoardHeight(boardHeight);

        // WHEN
        int actualSquareHeight = board.squareHeight();

        // THEN
        int expectedSquareHeight = panelHeight / boardHeight;
        Assert.assertEquals(expectedSquareHeight, actualSquareHeight);
    }


}
