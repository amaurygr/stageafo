package com.halosys.app.stageafo;

import com.halosys.app.stageafo.ciphering.CaesarCiphering;
import com.halosys.app.stageafo.ciphering.VigenereCiphering;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ciphering {

    private static final Logger LOGGER = LoggerFactory.getLogger(Ciphering.class);

    // Cliquer sur le triangle vert à gauche dans la marge pour lancer
    public static void main(String[] args) {

        int keyCesar = 11;
        String keyVigenere = "SECRET";

        String message = "CECI EST UN MESSAGE SECRET";
        System.out.println("Message en clair: " + message);

        System.out.println("\n- Clef césar    : " + keyCesar);
        System.out.println("- Clef Vigenère : " + keyVigenere);

        // Chiffrement de César
        String caesarCiphered = CaesarCiphering.cipher(message, keyCesar);

        System.out.println("\n\t-- Chiffrement César --");
        System.out.println("Message chiffré   : " + caesarCiphered);

        // Déchiffrement César
        String caesarDeciphered = CaesarCiphering.decipher(caesarCiphered, keyCesar);

        System.out.println("\n\t-- Dechiffrement César --");
        System.out.println("Message déchiffré : " + caesarDeciphered);

        // Chiffrement Vigenère
        String vigenereCiphered = VigenereCiphering.cipher(message, keyVigenere);

        System.out.println("\n\t-- Chiffrement Vigenère --");
        System.out.println("Message chiffré   : " + vigenereCiphered + "");

        // Déchiffreent Vigenère
        String vigenereDeciphered = VigenereCiphering.decipher(vigenereCiphered, keyVigenere);

        System.out.println("\n\t-- Déchiffrement Vigenère --");
        System.out.println("Message déchiffré : " + vigenereDeciphered);
    }
}