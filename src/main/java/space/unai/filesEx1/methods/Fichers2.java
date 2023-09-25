package space.unai.filesEx1.methods;
/*
 * AUTHOR: UNAI MEDINA FERNÁNDEZ
 * CURSO: 2 DAM
 * FECHA: 25/09/2023
 */

import java.io.FileNotFoundException;
import java.nio.file.*;
import java.io.IOException;

public class Fichers2 {
    public static void encryptUsingFiles(String originalFilePath, String encryptedFilePath) {
        try {
            byte[] originalBytes = Files.readAllBytes(Paths.get(originalFilePath));
            byte[] encryptedBytes = new byte[originalBytes.length];

            for (int i = 0; i < originalBytes.length; i++) {
                // Encriptamos cada byte usando XOR con una llave fija (ej. 0x5A)
                encryptedBytes[i] = (byte) (originalBytes[i] ^ 0x5A);
            }

            Files.write(Paths.get(encryptedFilePath), encryptedBytes); // Escribimos en el fichero.

            System.out.println("[✓] Fichero " + originalFilePath + " modificado en " + encryptedFilePath + ".");

        } catch (FileNotFoundException ex) {
            System.out.println("[!] ERROR: " + ex.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("[!] ERROR: " + e.getMessage());
        }
    }

    public static void decryptUsingFiles(String encryptedFilePath, String decryptedFilePath) {
        encryptUsingFiles(encryptedFilePath, decryptedFilePath); // XOR se puede desencriptar usando el mismo método
    }
}
