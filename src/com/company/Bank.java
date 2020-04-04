package com.company;

public class Bank {
    private int internalStorage = 0;

    public int getInternalStorage() {
        return internalStorage;
    }

    public void deposit(int internalStorage) {
        this.internalStorage += internalStorage;
    }

    public int cookieRemoval (int sum){
        if (internalStorage < sum || sum < 0){
            try {
                System.err.println("Внимание! печенечная недостаточность!");
                throw new CookieWithdrawalException("введенная сумма меньше чем остаток на счете. " +
                        "Либо сумма введена не коректно.\nОстаток на счете = " + internalStorage + "\nВведенная сумма = " + sum);
            } catch (CookieWithdrawalException e) {
                e.printStackTrace();
            }
        }
        internalStorage -= sum;
        return sum;
    }
}