package com.jasonderek.tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    private static final int DELAY = 100;

    private Timer timer;
    private JLabel statusBar;
    private int boardWidth;
    private int boardHeight;

    public int curX;
    public int curY;

    private boolean tiles[][];

    public Board(JLabel statusBar, int boardWidth, int boardHeight) {
        this.statusBar = statusBar;
        this.timer = new Timer(DELAY, this);
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        tiles = new boolean[boardWidth][boardHeight];

        addKeyListener(new TetrisKeyAdapter());
    }

    public void start() {
        timer.start();
        newPiece();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        actionPerformedMethod();
    }

    public void actionPerformedMethod() {
        if (!tryMoveTo(curX, curY + 1)) {
            addToTiles(curX, curY);
        }

        repaint();
    }

    public boolean tryMoveTo(int newX, int newY) {
        if (canMoveTo(newX, newY)) {
            makeMoveTo(newX, newY);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean canMoveTo(int newX, int newY) {
        if (newX < 0 || newX >= boardWidth || newY < 0 || newY >= boardHeight) {
            return false;
        }
        if (tiles[newX][newY]) {
            return false;
        }
        return true;
    }

    public void makeMoveTo(int newX, int newY) {
        curX = newX;
        curY = newY;
        repaint();
    }

    public void addToTiles(int x, int y) {
        if (0 <= x && x < boardWidth && 0 <= y && y < boardHeight) {
            tiles[x][y] = true;

            newPiece();
        }
    }

    public boolean getTile(int x, int y) {
        return tiles[x][y];
    }

    public void paint(Graphics g) {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                drawSquare(g, j, i, false);
            }
        }

        drawSquare(g, curX, curY, true);
    }

    private void newPiece() {
        curX = boardWidth / 2;
        curY = 0;
    }

    private void drawSquare(Graphics g, int x, int y, boolean isCurPiece) {
        Color colors[] = { new Color(255, 255, 255), new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0)
        };

        Color color;
        if (isCurPiece || tiles[x][y]) {
            color = colors[1];
        }
        else {
            color = colors[0];
        }

        int scaledX = x * squareWidth();
        int scaledY = y * squareHeight();

        g.setColor(color);
        g.fillRect(scaledX + 1, scaledY + 1, squareWidth() - 1, squareHeight() - 1);
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

    public int getBoardHeight() {
        return boardHeight;
    }

    class TetrisKeyAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            System.out.println("in keyPressed");

            int keycode = e.getKeyCode();

            switch (keycode) {
                case KeyEvent.VK_LEFT:
                    tryMoveTo(curX - 1, curY);
                    break;
                case KeyEvent.VK_RIGHT:
                    tryMoveTo(curX + 1, curY);
                    break;
                case KeyEvent.VK_DOWN:
                    tryMoveTo(curX, curY);
                    break;
                case KeyEvent.VK_UP:
                    tryMoveTo(curX, curY);
                    break;
                default:
                    break;
            }
        }
    }
}
