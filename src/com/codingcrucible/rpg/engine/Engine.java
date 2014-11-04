/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codingcrucible.rpg.engine;

import com.codingcrucible.rpg.engine.window.Window;
import com.codingcrucible.rpg.engine.window.WindowFactory;

public class Engine {

    Window w;
    
    public static class Builder {

        Window w;
        String name;
        
        public Builder() {
        }

        public Window getWindow() {
            return w;
        }

        public void addWindow(String name, int width, int height){
            this.name = name;
            w = WindowFactory.createWindow(name, width, height);
        }
    }
    
    public Engine(Builder b) {
        w = b.w;
    }
    
    public void start(){
        w.setVisible(true);
    }
    
}
