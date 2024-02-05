Instructions for compiling and running the ImageToChar application:

### 1. Open a terminal/command prompt.

### 2. Navigate to the root folder of the project (ImagesToChar).

### 3. Compile the Java files using the following command:

      javac -d ./target/ ./src/java/fr/y1337/printer/app/Program.java ./src/java/fr/y1337/printer/logic/Logic.java


### 4. Run the application using the following command:

      java -cp ./target fr.y1337.printer.app.Program.Program <path_to_image> <white_character> <black_character>

   Replace <path_to_image> with the full path to the BMP image file.
   
   Replace <white_character> with the character to represent white pixels.
   
   Replace <black_character> with the character to represent black pixels.
   

   <path_to_image> : ./images/image.bmp
   
   <white_character> : .
   
   <black_character> : 0
   
