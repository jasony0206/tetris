package com.jasonderek.tetris;

/**
 * Created by Derek on 9/25/2015.
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tetris extends JFrame {
    JLabel statusBar;

    public Tetris() {

        statusBar = new JLabel(" 0");
        add(statusBar, BorderLayout.NORTH);

        setSize(200, 400);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JLabel getStatusBar() {
        return statusBar;
    }

    public static void main(String[] args) {
        Tetris game = new Tetris();
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
