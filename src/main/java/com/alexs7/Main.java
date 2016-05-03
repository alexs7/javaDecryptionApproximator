package com.alexs7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 27/04/2016.
 */
public class Main {

    public static void main(String [] args) throws IOException {

        double threshold = Double.parseDouble(args[2]);

        if(args.length != 3 || threshold < 0 || threshold > 1 ){
            throw new IllegalArgumentException("Please enter 3 values, file to read from, new filename to be created, and threshold 0 from 1.0");
        }

        String fileToRead = args[0];
        String fileToWrite = args[1];

        ArrayList<String> data = FileLoader.load(fileToRead);

        Decrypter decrypter = new Decrypter(data,threshold);
        List<EncryptedDataDistanceWrapper> results = decrypter.analyzeData();
        JSONFileWriter.write(results,fileToWrite);

    }

}
