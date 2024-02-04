package fr.1337.printer.logic;

package fr.1337.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Logic {
    public void printImage(String imagePath, char whiteChar, char blackChar) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            int width = image.getWidth();
            int height = image.getHeight();

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int pixel = image.getRGB(x, y);
                    char character = (pixel == -1) ? whiteChar : blackChar;
                    System.out.print(character);
                }
                System.out.println(); // Move to the next line after each row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
