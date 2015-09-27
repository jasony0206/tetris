package com.jasonderek.tetris;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    private JLabel statusBar;
    private Timer timer;

    private int boardWidth;
    private int boardHeight;

    public JLabel getStatusBar() {
        return statusBar;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void setBoardWidth(int boardWidth) {
        this.boardWidth = boardWidth;
    }

    public void setBoardHeight(int boardHeight) {
        this.boardHeight = boardHeight;
    }

    public Board(JLabel statusBar) {
        this.statusBar = statusBar;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
    }

    public void paint(Graphics g) {
        System.out.println("running paint");
    }

    public void start() {
        timer.start();
    }

    public int squareWidth() {
        return (int) getSize().getWidth() / boardWidth;
    }

    public int squareHeight() {
        return (int) getSize().getHeight() / boardHeight;
    }
}
