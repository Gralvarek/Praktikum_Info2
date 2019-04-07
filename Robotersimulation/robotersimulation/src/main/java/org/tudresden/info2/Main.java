package org.tudresden.info2;

import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        Rechteck A = new Rechteck();
        Rechteck B = new Rechteck(new Punkt(3,4), 1, 5, "B", Color.WHITE);

        A.setPosition(new Punkt(5,6));
        A.setBreite(6);
        A.setLaenge(7);
        A.setBezeichnung("A");
        A.setFarbe(Color.GREEN);

        A.setFarbe(Color.WHITE);
        System.out.println(A.toString());
        System.out.println(B.toString());

        A.bewegeUm(B.getPosition());

        System.out.println(A.toString());


    }
}