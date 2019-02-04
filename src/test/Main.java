package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;

public class Main {

    public static void main(String[] args) {

        String name = "jai changer la phrase ecore une foix %n";
        name+= "je pense";
        Path var = Paths.get("file.csv");

        try {
            Files.write(var, String.format(name).getBytes(), APPEND);
        } catch (IOException e) {
            System.out.println("erreur");
        }

    }
}
