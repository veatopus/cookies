package com.company;

import java.util.Random;
import java.util.Scanner;

public class Playground {
    private Scanner s = new Scanner(System.in);

    public void gameOfDice(Player player) {
        int rate;
        System.out.println("У вас сейчас " + player.getCookies() + " печенек");
        System.out.println("введите ставку, если хитите поставить все, то введите 'все'");
        String str = s.nextLine();

        if (str.equals("все")){
            rate = player.getCookies();
        } else {
            rate = Integer.parseInt(str);
        }

        if (rate > player.getCookies()) {
            try {
                throw new WrongNumberException();
            } catch (WrongNumberException e) {
                System.err.println("Срочно! срочно! печенечная недостаточность!");
                System.err.println("" +
                        "У вас нет столько печенек. \nостаток печенек = " + player.getCookies() + "\n" +
                        "Введенная сумма = " + rate);
                System.out.println("продолжем же2" +
                        "");
            }
        } else {
            Random r = new Random();
            int robotAssumption = r.nextInt(5) + 1;
            int assumption = r.nextInt(5) + 1;
            System.out.println("вам выпало -> " + assumption);
            System.out.println("роботу выпало -> " + robotAssumption);
            if (assumption > robotAssumption) {
                System.out.println("Победа!");
                player.setPositionPoint(player.getPositionPoint() + 1);
                player.setCookies(player.getCookies() + rate);
                System.out.println("тепеь у вас " + player.getCookies() + " печенек");
            } else if (robotAssumption > assumption) {
                System.out.println("Поражение!");
                player.setCookies(player.getCookies() - rate);
                System.out.println("тепеь у вас " + player.getCookies() + " печенек");
            } else {
                System.out.println("Ничья!");
            }
        }
    }
}
