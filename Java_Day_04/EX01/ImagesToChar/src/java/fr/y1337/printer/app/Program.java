package fr.y1337.printer.app.Program;

import fr.y1337.printer.app.Logic.Logic;

public class Program {
    public static void main(String[] args) {
        if (args.length != 3 || args[1].length() != 1 || args[2].length() != 1){
            System.out.println("Usage: java fr.42.printer.app.ImagePrinterApp <path_to_image> <white_character> <black_character>");
            return;
        }
        
        String imagePath = args[0];
        char whiteChar = args[1].charAt(0);
        char blackChar = args[2].charAt(0);

        Logic converter = new Logic();
        converter.printImage(imagePath, whiteChar, blackChar);
    }
}