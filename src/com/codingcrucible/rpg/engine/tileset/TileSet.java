/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codingcrucible.rpg.engine.tileset;

import java.awt.image.BufferedImage;

public interface TileSet {
    
    BufferedImage getTile(int id);
    
    BufferedImage[] getTiles();
}
