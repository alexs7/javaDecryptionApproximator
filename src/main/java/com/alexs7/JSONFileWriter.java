package com.alexs7;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ar1v13 on 03/05/16.
 */
public class JSONFileWriter {
    public static void write(List<EncryptedDataDistanceWrapper> results, String location) throws IOException {
        //{ “label”:”PASS”, “content”:”78IkAOaoFrCQE … rC=”,“reason”:”reasoning for label” }
        //{ “label”:”FAIL”, “content”:”78IkAOaoFrCQE … rC=”,“reason”:”unsafe encoding” }

        ArrayList<String> fileResults = new ArrayList<>();

        for (EncryptedDataDistanceWrapper encryptedDataDistanceWrapper : results){
            fileResults.add("{label:"+encryptedDataDistanceWrapper.getPassFlag()+","+
                            "content:"+encryptedDataDistanceWrapper.getFormattedEncryptedString()+","+
                            "reason:"+encryptedDataDistanceWrapper.getReason()+"}");
        }

        Files.write(Paths.get(location), fileResults );
    }
}
