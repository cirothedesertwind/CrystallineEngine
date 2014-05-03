/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codingcrucible.rpg.engine;

import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author aurix
 */
public class Main {

    public Main() {
        // Create frame with specific title

        Frame frame = new Frame("Example Frame");

        int width = 300;

        int height = 300;

        frame.setSize(width, height);

        frame.setVisible(true);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure to close this window?", "Really Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}
