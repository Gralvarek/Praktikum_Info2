package org.tudresden.info2;

import java.util.Scanner;

public class Spielfeld {

    private static int breite = 1000;
    private static int laenge = 1000;
    private Punkt[] poi;

    public Spielfeld() {

    }

    public Punkt[] punkte_eingeben() {
        Scanner s = new Scanner(System.in);
        
        try {
            System.out.println("How many Points of Interest?:");
            int i = s.nextInt();
            poi = new Punkt[i];
            int x, y;

            for(int count = 0; count < i; count++) {
                System.out.println("X: ");
                x = s.nextInt();
                System.out.println("Y: ");
                y = s.nextInt();
                poi[count] = new Punkt(x, y);
                //System.out.println(poi[count].toString());
            }

            s.close();
            return poi;

        } catch(Exception e) {
            s.close();
            throw e;
        }
    }

    public void POI_sortieren() {
        poi = punkte_eingeben();

        Punkt roboter = poi[0];

        System.out.println("Abstand: " + roboter.gibAbstand(poi[1]));
    }

}