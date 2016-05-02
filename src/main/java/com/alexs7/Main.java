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

        if(args.length != 2){
            //throw new IllegalArgumentException("Please enter 2 values, file to read from and new filename to be created");
        }

        //String fileToRead = args[0];
        //String fileToWrite = args[1];

        ArrayList<String> data = FileDecoder.load("/Users/alex/Projects/work/decoder/src/main/resources/interview_source.txt");

        Decrypter decrypter = new Decrypter(data);

//        ArrayList<String> results = decrypter.getDecryptedData();
        try {
            Files.write(Paths.get("/Users/alex/Projects/work/decoder/src/main/resources/decoded_UTF_8.txt"), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
