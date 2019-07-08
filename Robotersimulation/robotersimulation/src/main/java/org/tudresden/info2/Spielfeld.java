package org.tudresden.info2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Spielfeld {

    private static Spielfeld instance;

    private static final int BREITE = 1000;
    private static final int LAENGE = 1000;

    private ArrayList<Rechteck> hindernisse;

    private static Random zufallsgenerator;
    private static Leinwand leinwand;
    private Roboter robot;

    private Punkt[] poi;

    private Spielfeld() {
        zufallsgenerator = new Random();
        leinwand = Leinwand.getInstance();
        this.robot = new Roboter(new Punkt(0, 0), Color.GREEN, 30);
        this.zeichnen(this.robot);
    }

    public static Spielfeld getInstance() {
        if(instance == null) {
            return instance = new Spielfeld();
        } else {
            return instance;
        }
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

        } catch(InputMismatchException e) {
            System.out.println(e);
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

    public void hindernissliste_erzeugen() {
        Scanner s = new Scanner(System.in);
        try {
            int size = zufallszahl(15, 50);
            this.hindernisse = new ArrayList<Rechteck>(size);

            Rechteck neuHinderniss;
            int count = 0;

            for(int index = 0; index < size; index++){
                if(count < 50) {
                    neuHinderniss = this.zufallsrechteck(index);
                    this.hindernisse.add(neuHinderniss);
                    Iterator<Rechteck> iter = this.hindernisse.iterator();
                    int iterI = 0;
                    while(iter.hasNext() && iterI != this.hindernisse.size() - 1){
                        if(iter.next().ueberlappt(neuHinderniss)) {
                            iter.remove();
                            count++;
                        }
                        iterI++;
                    }
                }
                leinwand.warten(1);
            }
            
            this.zeichnen(hindernisse);
            s.close();

        } catch(Exception e) {
            s.close();
            throw e;
        }
    }

    public void hindernisse_umfahren() {
        Roboter.status = Roboter.Status.CONTINUE;
        for(int index = 0; index < this.hindernisse.size(); index++) {
            if(this.robot.ZuNah_linkeKante(this.hindernisse.get(index), 40.0)) {
                for(int indexD = 0; indexD < this.hindernisse.size(); indexD++) {
                    if(this.robot.ZuNah_obereKante(this.hindernisse.get(indexD), 30.0) && indexD != index) {
                        Roboter.status = Roboter.Status.FINISH;
                        break; 
                    } else {
                        Roboter.status = Roboter.Status.MOVEDOWN;
                    }

                }
            }
            if(this.robot.ZuNah_obereKante(this.hindernisse.get(index), 40.0)) {
                for(int indexR = 0; indexR < this.hindernisse.size(); indexR++) {
                    if(this.robot.ZuNah_linkeKante(this.hindernisse.get(indexR), 30.0) && indexR != index) {
                        Roboter.status = Roboter.Status.FINISH;
                        break;
                    } else {
                        Roboter.status = Roboter.Status.MOVERIGHT;
                    }
                    
                }
                
            }
            if(this.robot.anWand(Spielfeld.BREITE, Spielfeld.LAENGE)) {
                Roboter.status = Roboter.Status.FINISH;
                break;
            }
        }
        switch(Roboter.status) {
            case CONTINUE:
                this.robot.bewegeUm(1,1);
                break;
            case MOVEDOWN:
                this.robot.bewegeUm(0,1);
                break;
            case MOVERIGHT:
                this.robot.bewegeUm(1,0);
                break;
            case FINISH:
                System.out.println("Robot cannot continue...");
                break;
        }
        this.zeichnen(robot);
        leinwand.warten(10);
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
        return new Color(this.zufallszahl(50, 255), this.zufallszahl(50, 255), this.zufallszahl(50, 255));
    }

    private Rechteck zufallsrechteck(int index) {
        return new Rechteck(new Punkt(this.zufallszahl(50, BREITE), this.zufallszahl(50, LAENGE)), zufallszahl(25, 100), zufallszahl(25, 100), "Rechteck " + index, zufallsfarbe());
    }
    
}