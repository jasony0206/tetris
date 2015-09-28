package com.jasonderek.tetris;

import org.junit.Test;

import javax.swing.*;

public class TetrisTest {

    private Tetris tetris;

    @Test
    public void canCallConstructorWithParams() {
        // GIVEN
        JLabel statusBar = new JLabel("test label");
        int width = 4;
        int height = 2;
        String title = "title";

        Board board = new Board(statusBar, 10, 10);

        // WHEN
        tetris = new Tetris(width, height, title, board);

        // THEN
        // There is no problem
    }

}
