package ru.job4j.ood.lsp.mistakes.bank;

public class FastMoneyService extends CreditDepartment {

    public FastMoneyService(int moneyLimit) {
        super(moneyLimit);
    }

    @Override
    public void giveCredit(Borrower borrower, int moneyOrdered) {
        borrower.takeMoney(moneyOrdered);
    }
}

