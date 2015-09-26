package com.jasonderek.tetris;

import org.junit.Test;

import javax.swing.*;
import static org.mockito.Mockito.*;


/**
 * Created by jasonyoon on 9/26/15.
 */

public class TetrisTest {

    private Tetris tetris;

    @Test
    public void canCallConstructorWithParams() {
        // GIVEN
        JLabel statusBar = new JLabel("test label");
        int width = 4;
        int height = 2;
        String title = "title";
        Board board = mock(Board.class);

        when(board.getStatusBar()).thenReturn(statusBar);

        // WHEN
        tetris = new Tetris(width, height, title, board);

        // THEN
        verify(board, times(1)).start();
    }

}
