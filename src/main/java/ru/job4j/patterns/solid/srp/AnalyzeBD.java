package ru.job4j.patterns.solid.srp;

public interface AnalyzeBD {

    public void initProperties();

    public void initConnection();

    public void analyze();

    public void saveBD();

    //нарушение SRP, методы интерфейса имею разные цели.
}
