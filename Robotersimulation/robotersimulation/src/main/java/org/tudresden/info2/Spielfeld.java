package org.tudresden.info2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Spielfeld {

    private static final int BREITE = 1000;
    private static final int LAENGE = 1000;
    private static final Color HINTERGRUNDFARBE = Color.WHITE;

    private Punkt[] poi;
    private ArrayList<Rechteck> hindernisse;

    private static Random zufallsgenerator;
    private static Leinwand leinwand;

    public Spielfeld() {
        zufallsgenerator = new Random();
        leinwand = new Leinwand(LAENGE, BREITE, HINTERGRUNDFARBE);
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

    public void hindernisliste_erzeugen() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Wie viele Hindernisse?:");
            int i = s.nextInt();

            this.hindernisse = new ArrayList<Rechteck>(i);
            Rechteck neuHinderniss;

            int count = 0;
            boolean alreadyAdded;

            for(int index = 0; index < i; index++) {
                if(count <= 50) {
                    neuHinderniss = zufallsrechteck(index);
                    if(index == 0) {
                        this.hindernisse.add(neuHinderniss);
                    } else {
                        alreadyAdded = false;
                        for(int index2 = index - 1; index2 >= 0; index2--) {
                            if(neuHinderniss.ueberlappt(this.hindernisse.get(index2)) || alreadyAdded) {
                                count++;
                            } else {
                                this.hindernisse.add(neuHinderniss);
                                alreadyAdded = true;
                            }
                        }
                    }
                }
            }
            this.zeichnen(hindernisse);
            s.close();

        } catch(Exception e) {
            s.close();
            throw e;
        }
    }

    public void zeichnen(ArrayList<Rechteck> hindernisse) {
        leinwand.zeichnen(hindernisse);
    }
    
    private int zufallszahl(int von, int bis) {
        return zufallsgenerator.nextInt(bis - von + 1) + von; 
    }

    private Color zufallsfarbe() {
        return new Color(this.zufallszahl(0, 255), this.zufallszahl(0, 255), this.zufallszahl(0, 255));
    }

    private Rechteck zufallsrechteck(int index) {
        return new Rechteck(new Punkt(this.zufallszahl(0, 1000), this.zufallszahl(0, 1000)), zufallszahl(0, 100), zufallszahl(0, 100), "Rechteck " + index, zufallsfarbe());
    }

    
}