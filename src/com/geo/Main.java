package com.geo;

public class Main {
    public static void main(String[] args) {
        Four grandFour = new Four();
        grandFour.puissance = 200;
        grandFour.capacity = 50;

        Aliment cake = new Aliment();

        grandFour.cuire(cake);
        System.out.println("");
        cake.manger();

    }
}
