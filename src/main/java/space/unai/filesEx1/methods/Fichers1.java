package space.unai.filesEx1.methods;

import java.io.*;

/*
 * AUTHOR: UNAI MEDINA FERNÁNDEZ
 * CURSO: 2 DAM
 * FECHA: 25/09/2023
 */


public class Fichers1 {

    public static void encryptUsingIO(String originalFilePath, String encryptedFilePath) {
        try (FileInputStream inputStream = new FileInputStream(originalFilePath);
             FileOutputStream outputStream = new FileOutputStream(encryptedFilePath)) {

            int data;
            while ((data = inputStream.read()) != -1) {
                // Encriptamos cada byte usando XOR con una llave fija (ej. 0x5A)b
                int encryptedByte = data ^ 0x5A;
                outputStream.write(encryptedByte); // Escribimos en el fichero.
            }

            System.out.println("[✓] Fichero " + originalFilePath + " modificado en " + encryptedFilePath + ".");

        } catch (FileNotFoundException ex) {
            System.out.println("[!] ERROR: " + ex.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("[!] ERROR: " + e.getMessage());
        }
    }

    public static void decryptUsingIO(String encryptedFilePath, String decryptedFilePath) {
        encryptUsingIO(encryptedFilePath, decryptedFilePath); // XOR se puede desencriptar usando el mismo método
    }
}
