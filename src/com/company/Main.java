package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static Player player = new Player();
    private static Bank bank = new Bank();
    private static Playground playground = new Playground();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

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
                    e.printStackTrace();
                }
            }

            switch (userChoice) {
                case 1:
                    player.promotion();
                    break;
                case 2:
                    player.work();
                    break;
                case 3:
                    playground.gameOfDice(player);
                    break;
                case 4:
                    bank.cookieRemoval(player);
                    break;
                case 5:
                    bank.deposit(player);
                    break;
                case 6:
                    System.out.println("Остаток на счете = " + player.getCookies());
                    break;
            }
        i = 0;
        }
    }

}
