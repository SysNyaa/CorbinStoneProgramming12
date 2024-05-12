package com.module2.point5;

public class Main {
    public static void main(String[] args) {
        Cipher cipher = new Cipher(1);

        String message = "defend the east wall of the castle";
        String encrypted = cipher.encrypt(message);
        String decrypted = cipher.decrypt(encrypted);

        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encrypted);
        System.out.println("Decrypted Message: " + decrypted);
    }
}
