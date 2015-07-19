/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codingcrucible.rpg.tileset;

import java.awt.image.BufferedImage;

public final class TileTable implements TileSet {

    private final BufferedImage image;
    private final int tileWidth;
    private final int tileHeight;
    
    TileTable(BufferedImage image, int tileWidth, int tileHeight) {
        if (!(image.getWidth() % tileWidth == 0 &&
              image.getHeight() % tileHeight == 0))
            throw new IllegalArgumentException("Width and height must be"
                    + "a full grid of tiles");
                    
        this.image = image;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
    }
    
    @Override
    public BufferedImage getTile(int id) {
        int x = id % (image.getWidth() / tileWidth) * tileWidth;
        int y = id / (image.getWidth() / tileWidth) * tileHeight;
        return image.getSubimage(x, y, tileWidth, tileHeight);
    }

    @Override
    public BufferedImage[] getTiles() {
        BufferedImage[] tiles = new BufferedImage[
                (image.getWidth() / tileWidth) * 
                (image.getHeight() / tileHeight)];
        
        int index = 0;
        //for row major order
        for (int y = 0; y < image.getHeight(); y += tileHeight)
            for (int x = 0; x < image.getWidth(); x += tileWidth){
                tiles[index] = image.getSubimage(x, y, tileWidth, tileHeight);
                index++;
            }
                
        return tiles;
    }
    
}
