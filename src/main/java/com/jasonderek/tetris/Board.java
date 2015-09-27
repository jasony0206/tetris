package com.jasonderek.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jasonyoon on 9/26/15.
 */

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

    }

    public void start() {
        timer.start();
    }
}
