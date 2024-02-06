package fr.y1337.printer.app.Logic;

// package fr.y1337.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.*;


public class Logic {
    public void printImage(String imagePath, char whiteChar, char blackChar) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    int pixel = image.getRGB(x, y);
                    if (pixel == -1) {
                        System.out.print(whiteChar);
                    } else {
                        System.out.print(blackChar);
                    }
                }
                System.out.println(); // Move to the next line after each row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
