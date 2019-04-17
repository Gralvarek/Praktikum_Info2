package org.tudresden.info2;

import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        Spielfeld spiel = new Spielfeld();

        //spiel.POI_sortieren();
        spiel.hindernisliste_erzeugen();


        //Rechteck r1 = new Rechteck(new Punkt(1, 1), 20, 20, "bezeichnung", Color.BLACK);
        //Rechteck r2 = new Rechteck(new Punkt(22, 22), 20, 20, "bezeichnung", Color.BLACK);
        //System.out.println(r1.ueberlappt(r2));
        
    }
}