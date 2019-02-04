package com.geo;

public class Aliment {

    String name="";
    boolean estCuit;

    public void manger(){
        if (estCuit){
            System.out.println("l'aliment "+name+" est bien cuit tu peut le manger");
        }else {
            System.out.println("l'aliment "+name+" est cru");
        }
    }
}
