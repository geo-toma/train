package geo.dav.manage;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

public class MemberAccess {

    Scanner sc = new Scanner(System.in);
    Inscription inscription = new Inscription();
    List<String> database = new ArrayList<>();

    private int id;

    public void member(){
        try {
            database = Files.readAllLines(inscription.getBase());
        } catch (IOException e) {
            System.out.println("Erreur de lecture du fichier database");
        }
        System.out.println("Entrez l'identifiant du membre ");
        id = sc.nextInt();
    }

    public void memberInfo(){
        this.member();
        String info = database.get(id);
        String[] tabInfo = info.split(",");
        System.out.println("Name : "+tabInfo[0]);
        System.out.println("First name : "+tabInfo[1]);
        System.out.println("Age : "+tabInfo[2]+" ans");
        System.out.println("Addresse : "+tabInfo[3]);
        System.out.println("ID : "+tabInfo[4]);
        System.out.println("Solde : "+tabInfo[5]);
    }

    public void moneyDeposit(){
        this.member();
        String info = database.get(id);
        String[] tabInfo = info.split(",");
        System.out.println("Entrez le montant deposer ");
        double montant = sc.nextDouble();
        montant = Double.valueOf(tabInfo[5]) + montant;
        inscription.setAccountMontant(montant);
        String newValue = tabInfo[0]+","+tabInfo[1]+","+tabInfo[2]+","+tabInfo[3]+","+id+","+inscription.getAccountMontant();
        database.set(id, newValue);
        try {
            Files.write(inscription.getBase(), "".getBytes());
        } catch (IOException e) {
            System.out.println("Erreur de suppression");
        }
        for (int counter = 0; counter < database.size(); counter++) {
            try {
                Files.write(inscription.getBase(), (database.get(counter)+"\n").getBytes(), APPEND);
            } catch (IOException e) {
                System.out.println("Erreur de reecriture");
            }
        }
    }

    public void withdrawalOfMoney(){
        this.member();
        String info = database.get(id);
        String[] tabInfo = info.split(",");
        System.out.println("Entrez le montant retirer ");
        double montant = sc.nextDouble();
        montant = Double.valueOf(tabInfo[5]) - montant;
        inscription.setAccountMontant(montant);
        String newValue = tabInfo[0]+","+tabInfo[1]+","+tabInfo[2]+","+tabInfo[3]+","+id+","+inscription.getAccountMontant();
        database.set(id, newValue);
        try {
            Files.write(inscription.getBase(), "".getBytes());
        } catch (IOException e) {
            System.out.println("Erreur de suppression");
        }
        for (int counter = 0; counter < database.size(); counter++) {
            try {
                Files.write(inscription.getBase(), (database.get(counter)+"\n").getBytes(), APPEND);
            } catch (IOException e) {
                System.out.println("Erreur de reecriture");
            }
        }
    }
}
