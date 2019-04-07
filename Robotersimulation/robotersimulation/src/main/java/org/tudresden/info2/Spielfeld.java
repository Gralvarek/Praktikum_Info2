package org.tudresden.info2;

import java.util.InputMismatchException;
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
        
            for(int x = 0; x < i; x++) {
                System.out.println("X: ");
                poi[x].setX(s.nextInt());
                System.out.println("Y: ");
                poi[x].setY(s.nextInt()); 
            }
            s.close();
            return poi;

        } catch(InputMismatchException e) {
            System.out.println("Not an Integer");
            s.close();
            throw new InputMismatchException();
        }
    }

    public void POI_sortieren() {
        poi = punkte_eingeben();

        Punkt roboter = poi[0];

        System.out.println("Abstand: " + roboter.gibAbstand(poi[1]));
    }

}