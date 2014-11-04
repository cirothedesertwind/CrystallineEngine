/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codingcrucible.rpg.engine;

import com.codingcrucible.rpg.engine.data.GameData;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aurix
 */
public class Main {

    public static void main(String[] args) {
        
        String path = args[0];
        byte[] encodedBytes = null;
        
        try {
            encodedBytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String jsonString = new String(encodedBytes, StandardCharsets.UTF_8);
        
        Gson g = new Gson();
        GameData data = g.fromJson(jsonString, GameData.class);
        Engine.Builder b = new Engine.Builder();
        b.addWindow(data.name, data.width, data.height);
        Engine e = new Engine(b);
        e.start();
    }
}
