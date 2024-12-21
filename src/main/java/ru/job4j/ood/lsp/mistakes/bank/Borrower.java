package ru.job4j.ood.lsp.mistakes.bank;

public class Borrower {
    private boolean responsible;
    protected int moneyOnAccount;

    public Borrower(boolean responsible) {
        this.responsible = responsible;
        moneyOnAccount = 0;
    }

    public boolean isResponsible() {
        return responsible;
    }

    public void takeMoney(int givenMoney) {
        moneyOnAccount += givenMoney;
    }
}
