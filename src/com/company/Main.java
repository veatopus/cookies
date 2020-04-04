package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int jobPosition = 1;
    private static int positionPoint = 1;
    private static int cookies = 1;
    private static Scanner s = new Scanner(System.in);

    public static int getCookies() {
        return cookies;
    }

    public static void setCookies(int cookies) {
        Main.cookies = cookies;
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        while (true) {
            System.out.println("введтье номер действия которое хотите совершить");
            System.out.println("1. Поднять заработок");
            System.out.println("2. Работать");
            System.out.println("3. сыграть в кости");
            System.out.println("4. снять печеньки с банка");
            System.out.println("5. положить печеньки на счет в банке");
            System.out.println("6. посмотреть сколько у меня печенек");

            int userChoice = s.nextInt();

            if (userChoice > 6 || userChoice <= 0) {
                try {
                    throw new WrongNumberException("Введенное число не соответствует правилам");
                } catch (WrongNumberException e) {
                    System.err.println("Не правельное число!");
                }
            }

            switch (userChoice) {
                case 1:
                    promotion();
                    break;
                case 2:
                    work();
                    break;
                case 3:
                    gameOfDice();
                    break;
                case 4:
                    System.out.println("в банке сейчас " + bank.getInternalStorage() + " печенек");
                    System.out.println("введите сумму которую хотите снять");
                    int sum = s.nextInt();
                    setCookies(getCookies() + bank.cookieRemoval(sum));
                    break;
                case 5:
                    System.out.println("в банке сейчас " + bank.getInternalStorage() + " печенек");
                    System.out.println("введите сумму которую хотите положить на счет");
                    sum = s.nextInt();
                    if (sum > getCookies()) {
                        try {
                            throw new WrongNumberException();
                        } catch (WrongNumberException e) {
                            System.err.println("У вас нет столько печенек");
                        }
                    } else
                        bank.deposit(sum);
                    break;
                case 6:
                    System.out.println("Остаток на счете = " + getCookies());
                    break;
            }

        }
    }

    public static void gameOfDice() {
        System.out.println("введите ставку");
        int rate = s.nextInt();
        if (rate > getCookies()) {
            try {
                throw new WrongNumberException();
            } catch (WrongNumberException e) {
                System.err.println("Срочно! срочно! печенечная недостаточность!");
                System.err.println("" +
                        "У вас нет столько печенек. \nостаток печенек = " + getCookies() + "\n" +
                        "Введенная сумма = " + rate);
                System.out.println("продолжем же2" +
                        "");
            }
        }
        Random r = new Random();
        int robotAssumption = r.nextInt(5) + 1;
        int assumption = r.nextInt(5) + 1;
        System.out.println("вам выпало -> " + assumption);
        System.out.println("роботу выпало -> " + robotAssumption);
        if (assumption > robotAssumption) {
            System.out.println("Победа!");
            positionPoint += 1;
            setCookies(getCookies() + rate + rate);
        } else if (robotAssumption > assumption) {
            System.err.println("Поражение!");
            setCookies(getCookies() - rate);
        } else {
            System.out.println("Ничья!");
        }
    }

    public static void work() {
        setCookies(getCookies() + (100 * jobPosition));
    }

    public static void promotion() {
        if (positionPoint >= 100)
            jobPosition += 10;
        else {
            System.err.println("ОШИБКА!");
            System.out.println("что бы повысить заработок, нужно сыграть в кости еще " + (100 - positionPoint) + " раз");
        }
    }


}
