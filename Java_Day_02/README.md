# Day 02

## Exercise 00: File Signatures
## Exercise 01: Words
## Exercise 02: File Manager

# Java Collections API and Input/Output Streams

This README provides an overview of the Java Collections API and Input/Output Streams, including key concepts and their usage in Java programming.

## Java Collections API

The Java Collections API offers a rich set of interfaces and classes for storing and manipulating collections of objects efficiently. Here are some key components:

- **List\<T>**: Represents an ordered collection of elements.
- **Map\<K, V>**: Represents a collection of key-value pairs.
- **Set\<T>**: Represents a collection that contains no duplicate elements.
- **Queue\<E>**: Represents a collection designed for holding elements prior to processing.

These interfaces provide flexible ways to manage data structures in Java programs.

## Input/Output Streams

Input/Output Streams are fundamental in handling byte-oriented input and output operations in Java. Key classes include:

- **InputStream**: Abstract class for reading streams of bytes.
- **OutputStream**: Abstract class for writing streams of bytes.
- **FileInputStream**: Reads bytes from a file in the file system.
- **FileOutputStream**: Writes bytes to a file in the file system.

These classes enable efficient handling of file-based data in Java applications.

## Usage

To utilize the Java Collections API and Input/Output Streams effectively:

1. Choose appropriate collection interfaces and implementations based on your requirements.
2. Use Input/Output Streams for reading from and writing to files.
3. Combine Collections API with Input/Output Streams for tasks like file manipulation and data processing.

## Example

```java
// Example of using ArrayList from Java Collections API with FileInputStream
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();
        FileInputStream fis = new FileInputStream("input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        br.close();

        // Process lines as needed
        for (String l : lines) {
            System.out.println(l);
        }
    }
}
```

## Source : 

https://jenkov.com/tutorials/java-collections/index.html#collection


