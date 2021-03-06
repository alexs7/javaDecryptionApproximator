package com.alexs7;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by alex on 02/05/2016.
 */
public class Decrypter {

    private String mostValidString;
    private ArrayList<String> data;
    private double threshold;

    public Decrypter(ArrayList<String> data, double threshold) {
        if(data.isEmpty()){
            throw new NullPointerException("Data cannot be null");
        }

        this.data = data;
        this.mostValidString = getMostValidString(data);
        this.threshold = threshold;
    }

    private String getMostValidString(ArrayList<String> data) {
        int validCharFrequency = 0;
        Map<String, Integer> encryptedStringValidCharsFrequency = new TreeMap<String, Integer>();
        char[] validChars = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                                        'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                                        '0','1','2','3','4','5','6','7','8','9'};
        ArrayList validCharsList = new ArrayList();

        for (int i = 0; i < validChars.length; i++) {
            validCharsList.add(validChars[i]);
        }

        for(String encryptedString : data){
            for (int i = 0; i < encryptedString.length(); i++) {
                if(validCharsList.contains(encryptedString.charAt(i))){
                    validCharFrequency += 1;
                }
            }
            encryptedStringValidCharsFrequency.put(encryptedString,validCharFrequency);
            validCharFrequency = 0;
        }

        encryptedStringValidCharsFrequency = sortMap(encryptedStringValidCharsFrequency);
        return encryptedStringValidCharsFrequency.keySet().iterator().next();
    }

    private Map<String, Integer> sortMap(Map<String, Integer> unsortedMap) {
        Map<String, Integer> sortedResultMap = new LinkedHashMap<>();
        Stream<Map.Entry<String, Integer>> st = unsortedMap.entrySet().stream();

        st.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered( e -> sortedResultMap.put(e.getKey(), e.getValue()) );

        return sortedResultMap;
    }

    public List<EncryptedDataDistanceWrapper> analyzeData() {
        List<EncryptedDataDistanceWrapper> encryptedStringDistances = new ArrayList<>();
        int distance = 0;

        for(String encryptedString : data){
            distance = LevenshteinDistance.computeLevenshteinDistance(mostValidString,encryptedString);
            encryptedStringDistances.add(new EncryptedDataDistanceWrapper(encryptedString, distance));
        }

        Collections.sort(encryptedStringDistances,
                (o1, o2) -> Integer.compare(o1.getDistance(),o2.getDistance()));

        Collections.reverse(encryptedStringDistances);

        int indexThreshold = (int) (encryptedStringDistances.size()*threshold);
        for (int i = 0; i < encryptedStringDistances.size(); i++) {
            if(i <= indexThreshold){
                encryptedStringDistances.get(i).setPassFlag("PASS");
            }else{
                encryptedStringDistances.get(i).setPassFlag("FAIL");
            }
        }

        return encryptedStringDistances;
    }
}

