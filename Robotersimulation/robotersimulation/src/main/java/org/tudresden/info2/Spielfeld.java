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
        
        this.poi = punkte_eingeben();
        
        Punkt nextPoint;
        double sD, pSD;

        for(int x = 0; x < this.poi.length; x++) {
            sD = 0;
            pSD = Double.MAX_VALUE;
            for(int y = x + 1; y < this.poi.length; y++) {
                sD = this.poi[x].gibAbstand(poi[y]);
                if(sD < pSD) {
                    nextPoint = poi[x + 1];
                    poi[x + 1] = poi[y];
                    poi[y] = nextPoint;
                    pSD = sD;
                }       
            }
        }
        for(Punkt a : this.poi) {
            System.out.println(a);
        }
    }

}