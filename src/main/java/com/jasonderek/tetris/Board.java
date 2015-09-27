package com.jasonderek.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    private static final int DELAY = 500;

    private Timer timer;
    private JLabel statusBar;
    private int boardWidth;
    private int boardHeight;

    public Board(JLabel statusBar, int boardWidth, int boardHeight) {
        this.statusBar = statusBar;
        this.timer = new Timer(DELAY, this);
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }

    public void start() {
        timer.start();
    }

    // fires every tick
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }

    public void paint(Graphics g) {
        System.out.println("running paint");

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                drawSquare(g, j * squareWidth(), i * squareHeight());
            }
        }
    }

    private void drawSquare(Graphics g, int x, int y) {
        Color colors[] = { new Color(0, 0, 0), new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0)
        };

        Color color = colors[0];

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 1, squareHeight() - 1);
    }

    public JLabel getStatusBar() {
        return statusBar;
    }

    public int squareWidth() {
        return (int) getSize().getWidth() / boardWidth;
    }

    public int squareHeight() {
        return (int) getSize().getHeight() / boardHeight;
    }
}
