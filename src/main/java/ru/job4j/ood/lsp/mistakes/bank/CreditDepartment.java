package ru.job4j.ood.lsp.mistakes.bank;

public class CreditDepartment {
    protected int moneyLimit;

    public CreditDepartment(int moneyLimit) {
        this.moneyLimit = moneyLimit;
    }

    public void giveCredit(Borrower borrower, int moneyOrdered) {
        if (!borrower.isResponsible()) {
            throw new IllegalArgumentException("declined");
        }
        if (moneyOrdered > moneyLimit) {
            moneyOrdered = moneyLimit;
        }
        borrower.takeMoney(moneyOrdered);
    }
}
