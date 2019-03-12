package com.halosys.app.stageafo.ciphering;

import org.junit.Assert;
import org.junit.Test;


/**
 * Classe de test pour le chiffrement César
 */
public class CaesarCipheringTest {

    @Test
    public void testCipher_basic() {

        // On chiffre le message "ABCD" avec la clef 2
        String ciphered = CaesarCiphering.cipher("ABCD", 2);

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message basic n'est pas chiffré correctement", "CDEF", ciphered);
    }

    @Test
    public void testCipher_overflow() {

        // On chiffre un message qui contient des lettres en fin d'alphabet pour généré un dépassement de l'alphabet
        String ciphered = CaesarCiphering.cipher("XYZ", 5);

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message avec dépassement n'est pas chiffré correctement", "CDE", ciphered);
    }

    @Test
    public void testCipher_spaces() {

        // On chiffre un message qui contient des espaces
        String ciphered = CaesarCiphering.cipher("UN MESSAGE AVEC DES ESPACES", 5);

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message avec des espaces n'est pas chiffré correctement", "ZS RJXXFLJ FAJH IJX JXUFHJX", ciphered);
    }

    @Test
    public void testCipher_specialCharacters() {

        // On chiffre un message qui contient des caractère speciaux
        String ciphered = CaesarCiphering.cipher("A,.B/!%C*=", 5);

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message avec des caractères n'est pas chiffré correctement", "FGH", ciphered);
    }


    @Test
    public void testCipher_caseInconsistency() {

        // On chiffre un message qui contient des majuscules et des minuscules
        String ciphered = CaesarCiphering.cipher("AbCd", 2);

        // On test que le résultat est bien conforme à ce qui est attendu
        Assert.assertEquals("Message contenant des minuscules n'est pas chiffré correctement", "CDEF", ciphered);
    }

}