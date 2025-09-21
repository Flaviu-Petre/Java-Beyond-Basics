package org.example;

import models.PasswordEncryption;

import javax.crypto.SecretKey;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        PasswordEncryption passwordEncryption = new PasswordEncryption();

        SecretKey key = passwordEncryption.generateSecretKey();

        String encrypted = PasswordEncryption.encryptMessage("Hello World", key);
        System.out.println("Encrypted text: " + encrypted);

        String decrypted = PasswordEncryption.decryptMessage(encrypted, key);
        System.out.println("Decrypted text: " + decrypted);
    }
}