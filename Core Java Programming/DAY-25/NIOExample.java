package com.day25;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOExample {
    public static void main(String[] args) {
        Path inputPath = Paths.get("input.txt");
        Path outputPath = Paths.get("output.txt");
        try {
            Files.writeString(inputPath, "Hello, this is a test content.\nThis is the second line.\nAnd this is the third line.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileChannel inputFileChannel = FileChannel.open(inputPath, StandardOpenOption.READ);
             FileChannel outputFileChannel = FileChannel.open(outputPath, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inputFileChannel.read(buffer) > 0) {
                buffer.flip();  // Prepare the buffer for reading
                outputFileChannel.write(buffer);
                buffer.clear();  // Prepare the buffer for writing
            }

            System.out.println("Content has been copied from " + inputPath + " to " + outputPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
