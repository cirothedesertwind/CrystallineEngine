package com.codingcrucible.rpg.engine.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public final class ImageIO {
    
    private static final String[] JPEG_SUPPORTED_EXTS = {"jpg", "jpeg"};
    
    interface Decode {
        BufferedImage decode(File f);
    }
    
    enum Decoder implements Decode{
        PNG("png"){
            @Override
            public final BufferedImage decode(File f){
                try {
                    return javax.imageio.ImageIO.read(f);
                } catch (IOException ex) {
                    Logger.getLogger(ImageIO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        },
        JPG(JPEG_SUPPORTED_EXTS){
            @Override
            public final BufferedImage decode(File f){
                try {
                    return javax.imageio.ImageIO.read(f);
                } catch (IOException ex) {
                    Logger.getLogger(ImageIO.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        };
        
        private final String[] extensions;

        private Decoder(String[] extensions) {
            this.extensions = extensions;
        }

        private Decoder(String extension) {
            this.extensions = new String[1];
            extensions[0] = extension;
        }
        
        public boolean isSupported(String ext){
            for (String s : extensions)
                if (ext.equalsIgnoreCase(ext))
                    return true;
            
           return false;
        }
        
    }
    
    private ImageIO(){
    }
    
    public static final BufferedImage read(File f) throws FileNotFoundException, IOException{
        if (!f.exists())
            throw new FileNotFoundException("File does not exist at this path.");
        
        String ext = f.getAbsolutePath().split(".")[1];
        for (Decoder d : Decoder.values()){
            if (d.isSupported(ext))
                return d.decode(f);
        }
        
        throw new IOException("The format with the extension " + ext + " is not supported");
    }
    
}
