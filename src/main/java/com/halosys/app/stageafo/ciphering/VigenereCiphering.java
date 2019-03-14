package com.halosys.app.stageafo.ciphering;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VigenereCiphering {

    private static final Logger LOGGER = LoggerFactory.getLogger(VigenereCiphering.class);
    private static final short NB_OF_LETTERS_ALPHABET = ('Z' - 'A' + 1);

    private static boolean specialCharacter(char data) {

        if (data < 'A' || data > 'Z') {
            if (data != ' ') {
                return true;
            }
        }
        return false;
    }

    private static char cipherDeplaceCharacter(char data, char keyChar, boolean ciphering) {

        char offsetData;

        if (ciphering) {
            offsetData = (char) (data + keyChar - 'A' + 1);
            if (offsetData > 'Z') {
                offsetData -= NB_OF_LETTERS_ALPHABET;
            }
        } else {
            offsetData = (char) (data - keyChar + 'A' - 1);
            if (offsetData < 'A') {
                offsetData += NB_OF_LETTERS_ALPHABET;
            }
        }

        return offsetData;
    }

    private static String cipheringDeciphering(String startData, String key, boolean deplaceCharacterCiphering) {

        int dataLength = startData.length();
        int dataCharComp = 0;
        char keyChar = ' ';
        int keyCharComp = 0;
        char dataChar;

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

            if (keyCharComp >= key.length()) {
                keyCharComp = 0;
            }

            keyChar = key.charAt(keyCharComp);

            if(dataChar != ' ') {
                keyCharComp++;
                dataChar = cipherDeplaceCharacter(dataChar, keyChar, deplaceCharacterCiphering);
            }

            if (dataCharComp < dataLength) {
                data[dataCharComp] = dataChar;
                dataCharComp++;
            }
        }

        String endData = new String(data);
        return endData;
    }

    public static String cipher(String clearData, String key) {
        return cipheringDeciphering(clearData, key, true);
    }

    public static String decipher(String cipheredData, String key) {
        return cipheringDeciphering(cipheredData, key, false);
    }
}
