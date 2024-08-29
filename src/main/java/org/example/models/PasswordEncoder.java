package org.example.models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {

    public static String hashPassword(String password) {
        try {
            // Tworzymy instancję obiektu MessageDigest z algorytmem MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");

            // Przekształcamy hasło na tablicę bajtów
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Konwertujemy zakodowane bajty na format hexadecymalny (czyli "czytelny" dla człowieka)
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
}
