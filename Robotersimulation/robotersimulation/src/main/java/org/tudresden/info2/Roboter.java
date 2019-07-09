package org.tudresden.info2;

import java.awt.Color;

public class Roboter extends Kreis {

    private Stichwort stichwort;

    // enum acting as status flag for the QNA session
    public enum Stichwort {
        NAME,
        CREATOR,
        SEX,
        AGE,
        END;
    }

    public static Status status;

    // enum acting as status flag for robot on the playing field
    public enum Status {
        CONTINUE,
        MOVEDOWN,
        MOVERIGHT,
        FINISH;
    }    

    // public constructor
    public Roboter(Punkt position, Color farbe, int durchmesser) {
        super(position, farbe, durchmesser);
        Roboter.status = Status.CONTINUE;
    }

    // Start of the qna code
	public void spracherkennung() {
        boolean stopScan = false; // flag to end qna session
        String line; // line to be read into

        do {
            line = Main.scan.nextLine();
            line = line.toLowerCase(); // sets the readin line to all lower case for easier parsing
            line = line.replace("?", ""); // removes the question mark so that it doesn't interfere with the program
            String[] words = line.split(" "); // splits the string into an array with a bunch of words
            for(String str: words) {
                switch(str) {
                    case "name":
                        this.stichwort = Stichwort.NAME;
                        break;
                    case "creator":
                        this.stichwort = Stichwort.CREATOR;
                        break;
                    case "sex":
                        this.stichwort = Stichwort.SEX;
                        break;
                    case "age":
                        this.stichwort = Stichwort.AGE;
                        break;
                    case "old":
                        this.stichwort = Stichwort.AGE;
                        break;
                    case "start":
                        this.stichwort = Stichwort.END;
                        break;
                    case "end":
                        this.stichwort = Stichwort.END;
                        break;
                }

            }
            switch(this.stichwort) { // based on what was inputted, returns different output
                case NAME:
                    System.out.println("I'm BOB!");
                    break;
                case CREATOR:
                    System.out.println("I was made by James!");
                    break;
                case SEX:
                    System.out.println("Robots don't have a sex silly, but a gender sure. We aren't close enough yet though. ;)");
                    break;
                case AGE:
                    System.out.println("4/20/69");
                    break;
                case END:
                    stopScan = true;
                    System.out.println("Ending...");
                    System.out.println("Starting path finding mission now...");
                    break;
                default:
                    System.out.println("Please enter a valid command...");
            }

        } while(!stopScan);
    }

    // function to see if the robot is on the edge of the playing field
    public boolean anWand(int WandX, int WandY) {
        if(this.position.getX() == WandX || this.position.getY() == WandY) {
            return true;
        } else {
            return false;
        }
    }

    // function to see if the robot is within the X Plane of a specific figure
    public boolean Zwischen_X(Figur figur) {
        if(this.maxX() < figur.maxX() && this.maxX() > figur.minX()) {
            return true;
        } else if(this.minX() < figur.maxX() && this.minX() > figur.minX()) {
            return true;
        } else {
            return false;
        }
    }

    // function to see if the robot is within the Y Plane of a specific figure
    public boolean Zwischen_Y(Figur figur) {
        if(this.maxY() < figur.maxY() && this.maxY() > figur.minY()) {
            return true;
        } else if(this.minY() < figur.maxY() && this.minY() > figur.minY()) {
            return true;
        } else {
            return false;
        }
    }

    // checks to see if the robot is too close to a vertical edge of a figure, within a specific tolerance
    public boolean ZuNah_vertikaleKante(Figur figur, double toleranz) {
        double abstand = Math.abs(-(figur.minX() - this.getPosition().getX())*(figur.maxY() - figur.minY()))/(Math.sqrt(Math.pow(figur.maxY() - figur.minY(), 2)));
        return (toleranz >= abstand) && this.Zwischen_Y(figur);
    }

    // checks to see if the robot is too close to a vertical edge of a figure, within a specific tolerance
    public boolean ZuNah_horizontaleKante(Figur figur, double toleranz) {
        double abstand = Math.abs((figur.maxX() - figur.minX())*(figur.minY() - this.getPosition().getY()))/(Math.sqrt(Math.pow(figur.maxX() - figur.minX(), 2)));
        return (toleranz >= abstand) && this.Zwischen_X(figur);
    }
}