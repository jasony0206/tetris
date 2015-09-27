package com.jasonderek.tetris;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    private JLabel statusBar;
    private Timer timer;

    private int boardWidth;
    private int boardHeight;

    public Board(JLabel statusBar, int boardWidth, int boardHeight) {
        this.statusBar = statusBar;
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
        drawSquare(g, 1, 1);
    }

    private void drawSquare(Graphics g, int x, int y) {
        Color colors[] = { new Color(0, 0, 0), new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0)
        };

        Color color = colors[0];

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
    }

    public JLabel getStatusBar() {
        return statusBar;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int squareWidth() {
        return (int) getSize().getWidth() / boardWidth;
    }

    public int squareHeight() {
        return (int) getSize().getHeight() / boardHeight;
    }
}
