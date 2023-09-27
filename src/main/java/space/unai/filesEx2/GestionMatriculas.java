package space.unai.filesEx2;
/*
 * AUTHOR: UNAI MEDINA FERNÁNDEZ
 * CURSO: 2 DAM
 * FECHA: 26/09/2023
 */

import space.unai.filesEx2.managers.Alumne;

import javax.net.ssl.SSLEngineResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class GestionMatriculas {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Alumne.load(); // Carrega la configuració

        int option = 0;
        do {
            loadMenuText();
            option = sc.nextInt();

            switch (option) {
                case 1:
                    createAlumne();
                    break;
                case 2:
                    deleteAlumne();
                    break;
                case 3:
                    try {
                        listAlumnes();
                    } catch (InterruptedException e) {
                        System.out.println("[!] " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("[!] Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("[!] Opción no valida: Vuelve a probar.");
                    break;
            }
        } while (option != 0);
    }

    private static void loadMenuText() {
        System.out.println("========================");
        System.out.println("1. Crear alumno");
        System.out.println("2. Borrar alumno");
        System.out.println("3. Listar alumnos");

        System.out.println("0. Cerrar");
        System.out.println("========================");
        System.out.println("Tu opcion:");
    }

    private static void createAlumne() {
        System.out.println("[?] CREACIÓN DE ALUMNOS [?]");
        System.out.println("--------------------------");
        System.out.println("[?] Matrícula alumno:");
        String matricula = sc.next();
        System.out.println("[?] Nombre de alumno:");
        sc.nextLine();
        String nombre = sc.nextLine();

        try {

            FileWriter fileWriter = new FileWriter("alumnes/" + matricula + ".txt", true);
            fileWriter.write(nombre);
            fileWriter.close();
            System.out.println("[!] Alumno creado correctamente");
            System.out.println("[!] Saliendo del programa....");
            System.exit(SSLEngineResult.Status.OK.ordinal());
        } catch (IOException e) {
            System.out.println("[!] ERROR: " + e.getMessage());
        }
    }

    private static void deleteAlumne() {
        System.out.println("[?] CREACIÓN DE ALUMNOS [?]");
        System.out.println("--------------------------");
        System.out.println("[?] Matrícula alumno:");
        String matricula = sc.next();

        try {
            Alumne alumne = Alumne.findAlumneById(matricula);
            Alumne.deleteAlumne(alumne);
            System.out.println("[!] Saliendo del programa...");
            System.exit(SSLEngineResult.Status.OK.ordinal());
        } catch (IllegalArgumentException ex) {
            System.out.println("[!] " + ex.getMessage());
        }
    }

    private static void listAlumnes() throws InterruptedException {
        System.out.println("[!] LISTA DE ALUMNOS [!]");
        System.out.println("--------------------------");
        Alumne.alumnes.forEach(alumne -> {
            System.out.println(alumne.idMatricula + ". " + alumne.nombre);
        });

        Thread.sleep(1000);
    }
}
