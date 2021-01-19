package ru.job4j.patterns.solid.srp;

public interface CreateReport {

    public void createReportAccountancy(); //бухгалтерский отчёт

    public void createReportManagement(); //управленческий отчёт

    public void saveReportInFile(); // сохранение отчёта в файл

    public void output(); // отправка файла

}
