package ru.job4j.ood.lsp.productstore;

public class Trash  extends AbstractStore {

    @Override
    public void setLimitPercent() {
        setLowLimitPercent(1.0);
        setHighLimitPercent(1.5);
    }
}
