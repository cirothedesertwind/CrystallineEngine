/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codingcrucible.rpg.engine.window;

public class WindowFactory {

    private WindowFactory() {
    }
    
    public static final Window createWindow(String frameName, int width, int height){
        return new WindowImpl(frameName, width, height);
    }
    
    
}
