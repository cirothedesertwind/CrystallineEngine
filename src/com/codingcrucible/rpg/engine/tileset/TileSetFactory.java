/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codingcrucible.rpg.engine.tileset;

import java.awt.image.BufferedImage;

/**
 *
 * @author aurix
 */
public class TileSetFactory {
    
    public enum Strategy {
        LOAD_ALL;
    }
    
    public final static TileSet createTileSet(Strategy s, BufferedImage i, int tileWidth, int tileHeight){
        return new TileTable(i, tileWidth, tileHeight);
    }
}
