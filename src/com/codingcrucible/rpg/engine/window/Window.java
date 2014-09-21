/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codingcrucible.rpg.engine.window;

import java.awt.Frame;
import javax.swing.JOptionPane;

/**
 *
 * @author aurix
 */
public class Window {

    Frame f;
    
    public Window(String frameName, int width, int height) {
        Frame frame = new Frame(frameName);
        frame.setSize(width, height);
        frame.setVisible(true);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Do you want to close the game?", "Closing the Game?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

    }
     
}
