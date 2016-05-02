package com.alexs7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by alex on 27/04/2016.
 */
public class Main {

    public static void main(String [] args) {
        ArrayList<String> data = FileLoader.load("/Users/alex/Projects/work/decoder/src/main/resources/interview_source.txt");
        try {
            Files.write(Paths.get("/Users/alex/Projects/work/decoder/src/main/resources/decoded_UTF_8.txt"), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}