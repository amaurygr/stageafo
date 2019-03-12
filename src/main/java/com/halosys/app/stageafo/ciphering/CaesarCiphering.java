package com.halosys.app.stageafo.ciphering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.ref.Cleaner;

public class CaesarCiphering {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaesarCiphering.class);

    private static boolean keyTest(int key, int limitMax, int limitMin) {

        if (key > limitMax) {
            System.out.println("Clef superieur a " + limitMax + " !");
            return false;
        } else if (key < limitMin) {
            System.out.println("Clef inferieur a " + limitMin + " !");
            return false;
        }
        return true;
    }

    private static boolean specialCharacter(char data) {

        if(data < 'A' || data > 'Z') {
            if(data < 'a' || data > 'z') {
                if(data != ' ') {
                    return true;
                }
            }
        }
        return false;
    }

    private static char cipherDeplaceCharacter(char data, int key) {

        for(int i = 0; i < key; i++) {
            data++;
            if (data > 'Z') {
                data = 'A';
            }
        }
        return data;
    }

    private static char decipherDeplaceCharacter(char data, int key) {

        for(int i = 0; i < key; i++) {
            data--;
            if (data < 'a') {
                data = 'z';
            }
        }
        return data;
    }

    public static String cipher(String clearData, int key) {

        int dataLength = clearData.length();
        int comp = 0;
        char dataChar;

        if (!keyTest(key, 25, 1)) {
            return null;
        }

        clearData = clearData.toUpperCase();

        for(int i = 0; i < clearData.length(); i++) {

            if(!specialCharacter(clearData.charAt(i))) {
                dataChar = clearData.charAt(i);
            } else {
                dataLength--;
            }
        }

        char[] data = new char[dataLength];

        for(int i = 0; i < clearData.length(); i++) {

            if(!specialCharacter(clearData.charAt(i))) {
                dataChar = clearData.charAt(i);
            } else {
                continue;
            }

            if (dataChar != ' ') {
                dataChar = cipherDeplaceCharacter(dataChar, key);
            }

            if(comp < dataLength) {
                data[comp] = dataChar;
                comp++;
            }
        }
        String cipheredData = new String(data);
        return cipheredData;
    }

    public static String decipher(String cipheredData, int key) {

        int dataLength = cipheredData.length();
        int comp = 0;
        char dataChar;

        if (!keyTest(key, 25, 1)) {
            return null;
        }

        cipheredData = cipheredData.toLowerCase();

        for(int i = 0; i < cipheredData.length(); i++) {

            if(!specialCharacter(cipheredData.charAt(i))) {
                dataChar = cipheredData.charAt(i);
            } else {
                dataLength--;
            }
        }

        char[] data = new char[dataLength];

        for(int i = 0; i < cipheredData.length(); i++) {

            if(!specialCharacter(cipheredData.charAt(i))) {
                dataChar = cipheredData.charAt(i);
            } else {
                continue;
            }

            if (dataChar != ' ') {
                dataChar = decipherDeplaceCharacter(dataChar, key);
            }

            if(comp < dataLength) {
                data[comp] = dataChar;
                comp++;
            }
        }
        String clearData = new String(data);
        return clearData;
    }
}