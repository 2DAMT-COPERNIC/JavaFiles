package space.unai.filesEx2.managers;
/*
 * AUTHOR: UNAI MEDINA FERNÁNDEZ
 * CURSO: 2 DAM
 * FECHA: 26/09/2023
 */

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;

import javax.net.ssl.SSLEngineResult;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumne {

    public static List<Alumne> alumnes;
    public String idMatricula;
    public String nombre;


    public Alumne(String idMatricula, String nombre) {
        this.idMatricula = idMatricula;
        this.nombre = nombre;
    }

    public static void load() {
        alumnes = new ArrayList<>();
        try {
            File path = new File("alumnes/");
            if (!path.exists()) {
                path.mkdir();
                System.out.println("[!] Creando carpeta alumnes...");
                System.exit(SSLEngineResult.Status.OK.ordinal());
            }
            for (String s : Objects.requireNonNull(new File("alumnes/").getCanonicalFile().list())) {
                String[] filename = s.split("\\.");

                try (BufferedReader reader = new BufferedReader(new FileReader("alumnes/" + filename[0] + ".txt"))) {
                    Alumne alumne = new Alumne(filename[0], reader.readLine());
                    alumnes.add(alumne);
                    System.out.println("[!] ADDED: " + alumne.nombre);
                } catch (IOException e) {
                    System.out.println("[!] ERROR: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteAlumne(Alumne alumne) {
        alumnes.remove(alumne);
        File file = new File("alumnes/" + alumne.idMatricula + ".txt").getAbsoluteFile();
        if (file.exists()) {
            file.delete();
            System.out.println("[!] Alumne borrado!");
        } else {
            throw new IllegalArgumentException("El alumno o el ficero de alumno no existe.");
        }
    }

    public static Alumne findAlumneById(String matricula) {
        for (Alumne alumne : alumnes) {
            if (Objects.equals(alumne.idMatricula, matricula)) {
                return alumne;
            } else {
                throw new IllegalArgumentException("No existe la matricula!");
            }
        }
        return null;
    }
}
