package ru.job4j.ood.lsp.productstore;

public class WareHouse extends AbstractStore {

    @Override
    public void setLimitPercent() {
        setLowLimitPercent(0.0);
        setHighLimitPercent(0.25);
    }
}
