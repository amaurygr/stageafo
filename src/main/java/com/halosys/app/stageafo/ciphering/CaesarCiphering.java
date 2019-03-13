package com.halosys.app.stageafo.ciphering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaesarCiphering {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaesarCiphering.class);
    private static final short NB_OF_LETTERS_ALPHABET = ('Z' - 'A' + 1);
    private static final short MAX_KEY_LIMIT = 25;
    private static final short MIN_KEY_LIMIT = 1;

    private static boolean keyTest(int key, int limitMax, int limitMin) {

        if (key > limitMax) {
            System.out.println("Clef superieur à " + limitMax + " !");
            return false;
        } else if (key < limitMin) {
            System.out.println("Clef inferieur à " + limitMin + " !");
            return false;
        }
        return true;
    }

    private static boolean specialCharacter(char data) {

        if (data < 'A' || data > 'Z') {
            if (data != ' ') {
                return true;
            }
        }
        return false;
    }

    private static char cipherDeplaceCharacter(char data, int key) {

        char offsetData = (char) (data + key);

        if (offsetData > 'Z') {
            offsetData -= NB_OF_LETTERS_ALPHABET;
        } else if (offsetData < 'A') {
            offsetData += NB_OF_LETTERS_ALPHABET;
        }

        return offsetData;
    }

    private static String cipheringDeciphering(String startData, int key, int keyLimitMax, int keyLimitMin) {

        int dataLength = startData.length();
        int comp = 0;
        char dataChar;

        if (!keyTest(key, keyLimitMax, keyLimitMin)) {
            return null;
        }

        startData = startData.toUpperCase();

        for (int i = 0; i < startData.length(); i++) {

            if (specialCharacter(startData.charAt(i))) {
                dataLength--;
            }
        }

        char[] data = new char[dataLength];

        for (int i = 0; i < startData.length(); i++) {

            if (!specialCharacter(startData.charAt(i))) {
                dataChar = startData.charAt(i);
            } else {
                continue;
            }

            if (dataChar != ' ') {
                dataChar = cipherDeplaceCharacter(dataChar, key);
            }

            if (comp < dataLength) {
                data[comp] = dataChar;
                comp++;
            }
        }
        String endData = new String(data);
        return endData;
    }

    public static String cipher(String clearData, int key) {
        return cipheringDeciphering(clearData, key, MAX_KEY_LIMIT, MIN_KEY_LIMIT);
    }

    public static String decipher(String cipheredData, int key) {
        return cipheringDeciphering(cipheredData, -key, -MIN_KEY_LIMIT, -MAX_KEY_LIMIT);
    }
}