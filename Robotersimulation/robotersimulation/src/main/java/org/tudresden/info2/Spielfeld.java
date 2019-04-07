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
            Punkt[] enteredPoi = new Punkt[i];
            int x, y;

            for(int index = 0; index < i; index++) {
                System.out.println("X: ");
                x = s.nextInt();
                System.out.println("Y: ");
                y = s.nextInt();
                enteredPoi[index] = new Punkt(x, y);
            }

            s.close();
            return enteredPoi;

        } catch(Exception e) {
            s.close();
            throw e;
        }
    }

    public void POI_sortieren() {
        poi = punkte_eingeben();
        
        Punkt nextPoint, oldPoint;
        double sD = 0;
        double pSD = Double.MAX_VALUE;

        for(int x = 0; x < poi.length; x++) {
            for(int y = x + 1; y < poi.length; y++) {
                sD = poi[x].gibAbstand(poi[y]);
                if(sD < pSD) {
                    oldPoint = poi[x + 1];
                    nextPoint = poi[y];
                    poi[y] = oldPoint;
                    poi[x+1] = nextPoint;
                    pSD = sD;
                }
            }
            System.out.println(poi[x]);
        }
    }

}