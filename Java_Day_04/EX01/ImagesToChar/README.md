
Instructions for compiling, creating the JAR archive, and running the ImagesToChar application:

### 1. Open a terminal/command prompt.

### 2. Navigate to the root folder of the project (ImagesToChar).

### 3. Compile the Java files using the following command:
   ```bash
   javac -d ./target/ ./src/fr/42/printer/**/*.java


## Project Structure:

        ImagesToChar/
            ├── src/
            │   └── fr/
            │       └── 42/
            │           └── printer/
            │               ├── app/
            │               │   └── ImagePrinterApp.java
            │               └── logic/
            │                   └── ImageConverter.java
            ├── resources/
            │   ├── image.bmp
            │   └── manifest.txt
            ├── target/
            │   ├── fr/
            │   │   └── 42/
            │   │       └── printer/
            │   │           ├── app/
            │   │           │   └── ImagePrinterApp.class
            │   │           └── logic/
            │   │               └── ImageConverter.class
            │   └── images-to-chars-printer.jar
            └── README.txt


jar cvmf ./resources/manifest.txt ./target/images-to-chars-printer.jar -C ./target/ .
