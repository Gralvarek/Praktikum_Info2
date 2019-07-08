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

    public static Status status;

    public enum Status {
        CONTINUE,
        MOVEDOWN,
        MOVERIGHT,
        FINISH;
    }
    public Roboter(Punkt position, Color farbe, int durchmesser) {
        super(position, farbe, durchmesser);
        Roboter.status = Status.CONTINUE;
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

    public boolean anWand(int WandX, int WandY) {
        if(this.position.getX() == WandX || this.position.getY() == WandY) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Zwischen_X(Figur figur) {
        if(this.position.getX() <= figur.maxX() && this.position.getX() >= figur.minX()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Zwischen_Y(Figur figur) {
        if(this.position.getY() <= figur.maxY() && this.position.getY() >= figur.minY()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean ZuNah_linkeKante(Figur figur) {
        double abstand = this.position.gibAbstand(figur.getPosition());
        return false;
    }

    public boolean ZuNah_obereKante(Figur figur) {
        double abstand = this.position.gibAbstand(figur.getPosition());
        return false;
    }
}