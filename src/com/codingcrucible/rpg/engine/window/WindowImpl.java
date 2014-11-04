/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codingcrucible.rpg.engine.window;

import java.awt.Frame;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author aurix
 */
class WindowImpl implements Window {

    private final ScheduledExecutorService refreshScheduler
            = Executors.newScheduledThreadPool(1);
    private final Frame frame;

    public WindowImpl(String frameName, int width, int height) {
        frame = new Frame(frameName);
        frame.setSize(width, height);

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

        refreshScheduler.scheduleAtFixedRate(
                new Runnable() {
                    public void run() {
                        frame.repaint();
                    }
                }, 0, 20, TimeUnit.MILLISECONDS);

    }
    
    @Override
    public void setVisible(boolean visible){
        frame.setVisible(visible);
    }

}
