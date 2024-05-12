package com.module2.point5;

import java.util.HashMap;
import java.util.Map;

public class Cipher {
    private final int shift;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // Constructor to initialize the shift value
    public Cipher(int shift) {
        this.shift = shift;
    }

    // Encrypt the message
    public String encrypt(String msg) {
        // Create a map for encryption
        Map<Character, Character> encryptionMap = makeEncryptMap();
        // StringBuilder to store the encrypted message
        StringBuilder encryptedMsg = new StringBuilder();
        // Go over each character of the message
        for (char c : msg.toCharArray()) {
            if (Character.isLetter(c)) {
                // Encrypt letter characters
                char encryptedChar = encryptionMap.get(Character.toLowerCase(c));
                if (Character.isUpperCase(c)) {
                    encryptedChar = Character.toUpperCase(encryptedChar);
                }
                encryptedMsg.append(encryptedChar);
            } else {
                // Append non-letter characters as is
                encryptedMsg.append(c);
            }
        }
        return encryptedMsg.toString();
    }

    // Decrypt the encrypted message
    public String decrypt(String encryptedMsg) {
        // Create a map for decryption
        Map<Character, Character> decryptionMap = makeDecryptMap();
        // StringBuilder to store the decrypted message
        StringBuilder decryptedMsg = new StringBuilder();
        // Go over each character of the encrypted message
        for (char c : encryptedMsg.toCharArray()) {
            if (Character.isLetter(c)) {
                // Decrypt letter characters
                char decryptedChar = decryptionMap.get(Character.toLowerCase(c));
                if (Character.isUpperCase(c)) {
                    decryptedChar = Character.toUpperCase(decryptedChar);
                }
                decryptedMsg.append(decryptedChar);
            } else {
                decryptedMsg.append(c);
            }
        }
        return decryptedMsg.toString();
    }

    // Create the encryption map
    private Map<Character, Character> makeEncryptMap() {
        Map<Character, Character> encryptMap = new HashMap<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            char originalChar = ALPHABET.charAt(i);
            char encryptedChar = ALPHABET.charAt((i + shift) % ALPHABET.length());
            encryptMap.put(originalChar, encryptedChar);
            encryptMap.put(Character.toUpperCase(originalChar), Character.toUpperCase(encryptedChar));
        }
        return encryptMap;
    }

    // Create the decryption map
    private Map<Character, Character> makeDecryptMap() {
        Map<Character, Character> decryptMap = new HashMap<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            char encryptedChar = ALPHABET.charAt(i);
            char originalChar = ALPHABET.charAt((i - shift + ALPHABET.length()) % ALPHABET.length());
            decryptMap.put(encryptedChar, originalChar);
            decryptMap.put(Character.toUpperCase(encryptedChar), Character.toUpperCase(originalChar));
        }
        return decryptMap;
    }
}
