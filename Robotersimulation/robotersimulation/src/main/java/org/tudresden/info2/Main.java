package org.tudresden.info2;

public class Main {
    public static void main(String[] args) {

        Spielfeld sf = Spielfeld.getInstance();
        sf.hindernisliste_erzeugen();

        while(Roboter.status == Roboter.Status.CONTINUE) {
            sf.hindernisse_umfahren();
        }
        
    }
}