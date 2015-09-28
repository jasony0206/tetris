package com.jasonderek.tetris;

import java.awt.BorderLayout;
import javax.swing.*;

public class Tetris extends JFrame {

    public Tetris(int width, int height, String title, Board board) {
        add(board.getStatusBar(), BorderLayout.SOUTH);
        add(board);
        board.start();

        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        int width = 200;
        int height = 400;
        String title = "Tetris";
        JLabel statusBar = new JLabel("0");

        Board board = new Board(statusBar, 10, 20);

        Tetris game = new Tetris(width, height, title, board);
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
