package org.tudresden.info2;

import java.awt.Color;
import java.util.Scanner;

public class Roboter extends Kreis {

    private Stichwort stichwort;

    public enum Stichwort {
        NAME,
        HERSTELLER,
        GESCHLECHT,
        GEBURTSDATUM;
    }

    public Roboter(Punkt position, Color farbe, int durchmesser) {
        super(position, farbe, durchmesser);
    }


    public void spracherkennung() {
        Scanner s = new Scanner(System.in);
        boolean stopScan = false;
        String line;

        do {
            System.out.println("Please choose a command: Name, Hersteller, Geschlecht, Geburtsdatum, Ende...");
            line = s.nextLine();

            switch(line) {
                case "Name":
                    stichwort = Stichwort.NAME;
                    break;
                case "Hersteller":
                    stichwort = Stichwort.HERSTELLER;
                    break;
                case "Geschlecht":
                    stichwort = Stichwort.GESCHLECHT;
                    break;
                case "Geburtsdatum":
                    stichwort = Stichwort.GEBURTSDATUM;
                    break;
                case "Ende":
                    stopScan = true;
                    System.out.println("Ending...");
                    break;
                default:
                    System.out.println("Please enter a valid command...");
            }

        } while(!stopScan);
        s.close();
    }
}