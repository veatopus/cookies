package com.company;

//import java.util.Scanner;

public class Player {
    private int jobPosition = 1;
    private int positionPoint = 1;
    private int cookies = 1000000;
    //private Scanner s = new Scanner(System.in);

    public Player() { }

    public int getPositionPoint() {
        return positionPoint;
    }

    public void setPositionPoint(int positionPoint) {
        this.positionPoint = positionPoint;
    }

    public int getCookies() {
        return cookies;
    }

    public void setCookies(int cookies) {
        this.cookies = cookies;
    }

    public void work() {
        setCookies(getCookies() + (100 * jobPosition));
    }

    public void promotion() {
        if (positionPoint >= 100)
            jobPosition += 10;
        else {
            System.err.println("ОШИБКА!");
            System.out.println("что бы повысить заработок, нужно сыграть в кости еще " + (100 - positionPoint) + " раз");
        }
    }

}
