package geo.dav.manage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.APPEND;

public class Inscription {

    Scanner sc = new Scanner(System.in);

    private String userInfo , name, surname, address;
    private double  accountMontant;
    private int id, age;
    private Path base = Paths.get("database.csv");
    List<String> database = new ArrayList<>();

    public Path getBase() {
        return base;
    }

    public double getAccountMontant() {
        return accountMontant;
    }

    public void setAccountMontant(double accountMontant) {
        this.accountMontant = accountMontant;
    }

    /**
     * to inscribe members
     * @return
     */
    public String inscrire(){
        try {
            database = Files.readAllLines(getBase());
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier database");
        }
        id = database.size();
        System.out.println("");
        System.out.println("Enter member information");
        System.out.print("");
        System.out.print("Name : ");
        name = sc.next();
        System.out.print("First name : ");
        surname = sc.next();
        System.out.print("Age : ");
        age = sc.nextInt();
        System.out.print("Address : ");
        address = sc.next();
        System.out.println("");
        userInfo = name+","+surname+","+age+","+address+","+id+","+accountMontant+"\n";
        return String.format(userInfo);
    }

    /**
     * create file to stock members information
     */
    public void database(){

        try {
            Files.write(base, inscrire().getBytes(), APPEND);
        } catch (IOException e) {
            System.out.println("Error : file can be created");
        }
    }


}
