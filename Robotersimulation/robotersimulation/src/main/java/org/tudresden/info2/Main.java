package org.tudresden.info2;

public class Main {
    public static void main(String[] args) {

        Spielfeld sf = Spielfeld.getInstance();
        sf.hindernissliste_erzeugen();
        while(Roboter.status != Roboter.Status.FINISH) {
            sf.hindernisse_umfahren();
        }
        
    }
}