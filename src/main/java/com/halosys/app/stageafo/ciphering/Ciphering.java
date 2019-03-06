package com.halosys.app.stageafo.ciphering;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Ciphering {

    private static final Logger LOGGER = LoggerFactory.getLogger(Ciphering.class);


    public static void main(String[] args) {

        String message = "CECI EST UN MESSAGE SECRET";
        System.out.println("Message en clair: " + message);



        // Chiffrement de César
        System.out.println("-- Chiffrement de César --");

        int clefCaesar = 11;

        String caesarCiphered = CaesarCiphering.cipher(message, clefCaesar);

        System.out.println("Clef césar: " + clefCaesar);
        System.out.println("Message chiffré (César): " + caesarCiphered);
        System.out.println("");



        // Chiffrement Vigenère
        System.out.println("-- Chiffrement de Vigenère --");

        String clefVigenere = "SECRET";

        String vigenereCiphered = VigenereCiphering.cipher(message, clefVigenere);

        System.out.println("Clef Vigenère: " + clefVigenere);
        System.out.println("Message chiffré (Vigenère): " + vigenereCiphered);

        System.out.println("");
    }


}
