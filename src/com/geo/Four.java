package com.geo;

public class Four {

    int capacity = 20;
    int puissance = 100;

    public void cuire(Aliment nouriture){
        System.out.println("je cuit des aliments");
        System.out.println("avec ma capacity de "+capacity+" litres");
        System.out.println("et ma puissance de "+puissance+" watt");
        nouriture.estCuit =true;
    }
}
