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

    public static void main(String[] args) throws IOException {
        
        GameData data;
        
        //If a game is being loaded from a boot.json file
        if (args.length != 0) {
            String path = args[0];

            try {
                byte[] encodedBytes = Files.readAllBytes(Paths.get(path));
                String jsonString = new String(encodedBytes, StandardCharsets.UTF_8);
                Gson g = new Gson();
                data = g.fromJson(jsonString, GameData.class);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                throw ex;
            }   
        }
        else {
            // show standard initialization screen
            // important for new users to assure them that everything is ok
            data = new GameData();
            data.name = "RPG Engine";
            data.width = 800;
            data.height = 600;
        }
        
        Engine.Builder b = new Engine.Builder();
        b.addWindow(data.name, data.width, data.height);
        Engine e = b.build();
        e.start();
    }
}
