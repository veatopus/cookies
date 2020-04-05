package com.company;

import java.util.Scanner;

public class Bank {
    private int internalStorage = 0;
    Scanner s = new Scanner(System.in);

    public int getInternalStorage() {
        return internalStorage;
    }

    public void deposit(Player player) {
        System.out.println("В банке сейчас " + getInternalStorage() + " печенек");
        System.out.println("У вас сейсчас " + player.getCookies() + " печенек");
        System.out.println("введите сумму которую хотите положить на счет");
        int sum = s.nextInt();
        if (sum > player.getCookies()) {
            try {
                throw new CookieWithdrawalException("У вас нет столко печенек");
            } catch (CookieWithdrawalException e) {
                e.printStackTrace();
                System.err.println("Веденная сумма = " + sum);
                System.err.println("Всего печенек = " + player.getCookies());
            }
        } else {
            this.internalStorage += sum;
            player.setCookies(player.getCookies() - sum);
        }
    }

    public void cookieRemoval(Player player) {
        System.out.println("в банке сейчас " + getInternalStorage() + " печенек");
        System.out.println("введите сумму которую хотите снять");
        int sum = s.nextInt();
        if (internalStorage < sum || sum < 0) {
            try {
                System.err.println("Внимание! печенечная недостаточность!");
                throw new CookieWithdrawalException("введенная сумма меньше чем остаток на счете. " +
                        "Либо сумма введена не коректно.\nОстаток на счете = " + internalStorage + "\nВведенная сумма = " + sum);
            } catch (CookieWithdrawalException e) {
                e.printStackTrace();
            }
        } else {
            internalStorage -= sum;
            player.setCookies(player.getCookies() + sum);
        }
    }
}