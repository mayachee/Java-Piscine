
Instructions for compiling, creating the JAR archive, and running the ImagesToChar application:

### 1. Need to create target folder for compiled *.class files, resources and *.jar
--->    mkdir target
### 2. You need to migrate the resources folder using the command described below
--->    cp -R src/resources target/
### 3. Run the command below to compile .java files
--->    javac src/java/edu/school21/printer/app/Program.java src/java/edu/school21/printer/logic/Logic.java -d target
### 4. You need to create an application distribution kit - a JAR archive, this can be done using the code below
--->    jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target .
### 5. You can run the *.jar file with the following command
--->    java -jar target/images-to-chars-printer.jar . O

Input parameters for running the application:
The first argument is to enter a character to be used for white;
The second argument is to enter a character to be used for black;



## Project Structure:
# ToChar project folder

* src
    * source files
        * java
            * files of Java source code
                * fr.42.printer.*
                * ...
            * resources
                * image.bmp
                * ... (other resource files)
            * manifest.txt (description of the initial point for archive startup)
    * target
        * compiled .class files and archive
            * fr.42.printer.*
            * resources
                * images-to-chars-printer.jar



jar cvmf ./resources/manifest.txt ./target/images-to-chars-printer.jar -C ./target/ .
