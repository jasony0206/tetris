package com.jasonderek.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    private static final int DELAY = 100;

    private Timer timer;
    private JLabel statusBar;
    private int boardWidth;
    private int boardHeight;
    private int curX;
    private int curY;

    public Board(JLabel statusBar, int boardWidth, int boardHeight) {
        this.statusBar = statusBar;
        this.timer = new Timer(DELAY, this);
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }

    public void start() {
        timer.start();
        newPiece();
    }

    // fires every tick
    public void actionPerformed(ActionEvent actionEvent) {
        if (canMoveTo(curX, curY + 1)) {
            makeMoveTo(curX, curY + 1);
        }
        repaint();
    }

    public void paint(Graphics g) {
        System.out.println("running paint");

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                drawSquare(g, j * squareWidth(), i * squareHeight(), false);
            }
        }

        drawSquare(g, curX * squareWidth(), curY * squareHeight(), true);
    }

    private void newPiece() {
        curX = boardWidth / 2;
        curY = 0;
    }

    private boolean canMoveTo(int newX, int newY) {
        if (0 <= newX && newX < boardWidth && 0 <= newY && newY < boardHeight) {
            return true;
        }
        return false;
    }

    private void makeMoveTo(int newX, int newY) {
        curX = newX;
        curY = newY;
        repaint();
    }

    private void drawSquare(Graphics g, int x, int y, boolean isCurPiece) {
        Color colors[] = { new Color(255, 255, 255), new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0)
        };

        Color color;
        if (isCurPiece) {
            color = colors[1];
        }
        else {
            color = colors[0];
        }

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
