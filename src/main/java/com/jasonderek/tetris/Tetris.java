package com.jasonderek.tetris;

/**
 * Created by Derek on 9/25/2015.
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tetris extends JFrame {

    public Tetris(int width, int height, String title, Board board) {
        add(board.getStatusBar(), BorderLayout.NORTH);
        add(board);
        board.start();

        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JLabel statusBar = new JLabel("0")    ;
        int width = 200;
        int height = 400;
        String title = "Tetris";
        Board board = new Board(statusBar);

        Tetris game = new Tetris(width, height, title, board);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
