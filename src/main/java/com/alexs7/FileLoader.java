package com.alexs7;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.stream.Stream;

/**
 * Created by alex on 27/04/2016.
 */
public class FileLoader {
    public static ArrayList<String> load(String filePath) {
        ArrayList<String> data = new ArrayList<>();
        int offset = 0;

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

            stream.forEach(e -> {
                byte[] decodedStream = Base64.getDecoder().decode(e);
                decodedStream = Arrays.copyOfRange(decodedStream, offset, decodedStream.length);
                data.add(new String(decodedStream, StandardCharsets.UTF_8));
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
