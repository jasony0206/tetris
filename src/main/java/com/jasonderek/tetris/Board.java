package com.jasonderek.tetris;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    private JLabel statusBar;
    private Timer timer;

    public JLabel getStatusBar() {
        return statusBar;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
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

}
