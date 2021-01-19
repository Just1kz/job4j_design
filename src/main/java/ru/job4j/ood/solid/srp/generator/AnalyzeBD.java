package ru.job4j.ood.solid.srp.generator;

public interface AnalyzeBD {

    public void initProperties();

    public void initConnection();

    public void analyze();

    public void saveBD();

    //нарушение SRP, методы интерфейса имею разные цели.
}
