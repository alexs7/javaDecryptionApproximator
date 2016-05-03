package com.alexs7;

/**
 * Created by ar1v13 on 03/05/16.
 */
public class EncryptedDataDistanceWrapper {

    private int distance;
    private String encryptedString;
    private String passFlag;

    public EncryptedDataDistanceWrapper(String encryptedString, int distance) {
        this.encryptedString = encryptedString;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getEncryptedString() {
        return encryptedString;
    }

    public String getFormattedEncryptedString() {
        return encryptedString.replace("\n", "").replace("\r", "");
    }

    public void setPassFlag(String passFlag) {
        this.passFlag = passFlag;
    }

    public String getPassFlag() {
        return passFlag;
    }

    public String getReason(){
        if(passFlag == "PASS"){
            return "Small Levenshtein distance";
        }else{
            return "Large Levenshtein distance";
        }
    }
}
