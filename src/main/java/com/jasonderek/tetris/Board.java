package com.jasonderek.tetris;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jasonyoon on 9/26/15.
 */

public class Board extends JPanel implements ActionListener {

    private JLabel statusBar;

    public JLabel getStatusBar() {
        return statusBar;
    }

    public Board(JLabel statusBar) {
        this.statusBar = statusBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void start() {

    }
}
