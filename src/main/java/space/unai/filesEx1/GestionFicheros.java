package space.unai.filesEx1;

import jdk.jshell.Snippet;
import space.unai.filesEx1.methods.Fichers1;
import space.unai.filesEx1.methods.Fichers2;

import java.util.Scanner;

/*
 * AUTHOR: UNAI MEDINA FERNÁNDEZ
 * CURSO: 2 DAM
 * FECHA: 25/09/2023
 */
public class GestionFicheros {

    private static Scanner sc = new Scanner(System.in); // Inicializamos el Scanner

    public static void main(String[] args) {
        System.out.println("¿Que vols Encriptar (1), desencriptar (2):");
        int eleccio = sc.nextInt(); // Preguntamos el metodo

        if (eleccio == 1) { // Condicional de manual, si es 1 ejecuta encryptMenu() si es 2 el decryptMenu();
            encryptMenu();
        } else if (eleccio == 2) {
            decryptMenu();
        } else {
            System.exit(Snippet.Status.REJECTED.ordinal()); // Si no, salimos de la aplicación
        }


    }

    public static void encryptMenu() {
        System.out.println("------------------------");
        System.out.println("1. Método 1 (java.io.*)");
        System.out.println("2. Método 2 (java.nio.*)");
        System.out.println("");
        System.out.println("Elige método:");
        int eleccioE = sc.nextInt(); // Elegimos método

        System.out.println("------------------------"); // Elegimos RUTAs
        System.out.println("Ruta fitxer per encriptar:");
        String rutaE = sc.next();

        System.out.println("Ruta fitxer encriptat:");
        String rutaD = sc.next();
        System.out.println("------------------------");

        if (eleccioE == 1) { // Hacemos condicional para elegir método 1 o 2
            Fichers1.encryptUsingIO(rutaE, rutaD);
        } else if (eleccioE == 2) {
            Fichers2.encryptUsingFiles(rutaE, rutaD);
        } else {
            System.exit(Snippet.Status.REJECTED.ordinal());
        }
        System.out.println("------------------------");
    }

    public static void decryptMenu() {
        System.out.println("------------------------");
        System.out.println("1. Metode 1 (java.io.*)");
        System.out.println("2. Metode 2 (java.nio.*)");
        System.out.println("");
        System.out.println("Elige método:");
        int eleccioE = sc.nextInt();

        System.out.println("------------------------");
        System.out.println("Ruta fitxer per desencriptar:");
        String rutaE = sc.next();

        System.out.println("Ruta fitxer desencriptat:");
        String rutaD = sc.next();
        System.out.println("------------------------");

        if (eleccioE == 1) { // Condicional para método 1 o 2
            Fichers1.decryptUsingIO(rutaE, rutaD);
        } else if (eleccioE == 2) {
            Fichers2.decryptUsingFiles(rutaE, rutaD);
        } else {
            System.exit(Snippet.Status.REJECTED.ordinal());
        }
        System.out.println("------------------------");
    }
}