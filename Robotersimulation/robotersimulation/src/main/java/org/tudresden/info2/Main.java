package org.tudresden.info2;

import java.util.Scanner;

public class Main {
    public static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        Spielfeld sf = Spielfeld.getInstance();
        sf.getRobot().spracherkennung();
        sf.hindernissliste_erzeugen();
        sf.POI_sortieren();
        scan.close();
        sf.hindernisse_umfahren();
    
        
    }
}