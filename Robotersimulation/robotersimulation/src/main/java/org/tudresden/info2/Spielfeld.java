package org.tudresden.info2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Spielfeld {

    private static final int BREITE = 1000;
    private static final int LAENGE = 1000;
    private static final Color HINTERGRUNDFARBE = Color.WHITE;

    private ArrayList<Rechteck> hindernisse;

    private static Random zufallsgenerator;
    private static Leinwand leinwand;

    public Spielfeld() {
        zufallsgenerator = new Random();
        leinwand = new Leinwand(LAENGE, BREITE, HINTERGRUNDFARBE);
        this.zeichnen(new Roboter(new Punkt(4, 5), Color.GREEN, 3));
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

    public void zeichnen(Roboter robot) {
        leinwand.zeichnen(robot);
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