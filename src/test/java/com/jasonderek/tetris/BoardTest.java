package com.jasonderek.tetris;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class BoardTest {

    private Board board;
    private int boardWidth = 10;
    private int boardHeight = 20;

    @Before
    public void setup() {
        board = new Board(new JLabel(), boardWidth, boardHeight);
    }

    @Test
    public void canCallConstructorWithStatusBar() {
        // GIVEN
        JLabel expectedStatusBar = new JLabel("");

        // WHEN
        board = new Board(expectedStatusBar, boardWidth, boardHeight);

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
    public void canGetSquareWidthAndHeight() {
        // GIVEN
        boardWidth = boardHeight = 5;
        board = new Board(new JLabel(), boardWidth, boardHeight);

        int panelWidth = 100;
        int panelHeight = 200;
        board.setSize(panelWidth, panelHeight);

        // WHEN
        int actualSquareWidth = board.squareWidth();
        int actualSquareHeight = board.squareHeight();

        // THEN
        int expectedSquareWidth = panelWidth / boardWidth;
        int expectedSquareHeight = panelHeight / boardHeight;
        Assert.assertEquals(expectedSquareWidth, actualSquareWidth);
        Assert.assertEquals(expectedSquareHeight, actualSquareHeight);
    }

    @Test
    public void shouldAddSquareToTilesWhenHitsBottom() {
        // GIVEN
        board.curX = 0;
        board.curY = board.getBoardHeight() - 1;

        int oldX = board.curX;
        int oldY = board.curY;

        // WHEN
        board.actionPerformedMethod();

        // THEN
        Assert.assertEquals(true, board.tiles[oldX][oldY]);
    }

    
}
