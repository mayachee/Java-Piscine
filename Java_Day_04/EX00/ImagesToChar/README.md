Instructions for compiling and running the ImageToChar application:

1. Open a terminal/command prompt.

2. Navigate to the root folder of the project (ImagesToChar).

3. Compile the Java files using the following command:
   javac src/fr/42/printer/app/ImagePrinterApp.java src/fr/42/printer/logic/ImageConverter.java -d target

4. Run the application using the following command:
   java -cp target fr.42.printer.app.ImagePrinterApp <path_to_image> <white_character> <black_character>

   Replace <path_to_image> with the full path to the BMP image file.
   Replace <white_character> with the character to represent white pixels.
   Replace <black_character> with the character to represent black pixels.
