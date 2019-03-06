package com.halosys.app.stageafo.ciphering;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VigenereCipheringTest {


    @Test
    public void testCipher_basic() {

        // On chiffre le message "ABCD" avec la clef "CLEF"
        String ciphered = VigenereCiphering.cipher("ABCD", "CLEF");

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message basic n'est pas chiffré correctement", "ENHJ", ciphered);
    }

    @Test
    public void testCipher_overflow() {

        // On chiffre un message avec une clef qui contient des lettres en fin d'alphabet pour généré un dépassement de l'alphabet
        String ciphered = VigenereCiphering.cipher("AB", "YY");

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message avec dépassement n'est pas chiffré correctement", "ZA", ciphered);
    }

    @Test
    public void testCipher_spaces() {

        // On chiffre un message qui contient des espaces
        String ciphered = VigenereCiphering.cipher("UN MESSAGE", "CLEF");

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message avec des espaces n'est pas chiffré correctement", "XZ RKVEFMH", ciphered);
    }

    @Test
    public void testCipher_specialCharacters() {

        // On chiffre un message qui contient des caractère speciaux
        String ciphered = VigenereCiphering.cipher("A,.B/!%C*=", "AAA");

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message avec des caractères n'est pas chiffré correctement", "BCD", ciphered);
    }


    @Test
    public void testCipher_caseInconsistency() {

        // On chiffre un message qui contient des majuscules et des minuscules
        String ciphered = VigenereCiphering.cipher("AbCd", "AAAA");

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message minuscules n'est pas chiffré correctement", "BCDE", ciphered);
    }


    @Test
    public void testCipher_longKey() {

        // On chiffre un message avec une clef plus longue que le message
        String ciphered = VigenereCiphering.cipher("MESSAGE", "UNECLEFBIENLONGUE");

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message chiffré avec une longue clef n'est pas correct", "HSXVMNK", ciphered);
    }


    @Test
    public void testCipher_shortKey() {

        // On chiffre un message avec une clef plus longue que le message
        String ciphered = VigenereCiphering.cipher("MESSAGELONG", "CLEF");

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message chiffré avec une petite clef n'est pas correct", "PQXYDSJRRZL", ciphered);
    }

}