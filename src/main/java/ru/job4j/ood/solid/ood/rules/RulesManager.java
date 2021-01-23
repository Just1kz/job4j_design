package ru.job4j.ood.solid.ood.rules;

import ru.job4j.ood.solid.ood.model.Player;

public interface RulesManager extends RulesSteps, RulesQueue {
    public int getCountSteps();

    public void setCountSteps(int countSteps);

    boolean checkSymbol(String x, Player player);
    // не выделял отдельно потому что это специфично для данной игры
    // проверка хождения верным символом конкретного игрока в зависимости от начальных параметров игры

    boolean firstStep(int x);
    // не выделял отдельно потому что это специфично для данной игры
    // проверка первого хода по правилам данной игры

    int analyzeNextStep(String[][] x, Player player);
    // не выделял отдельно потому что это специфично для данной игры
    //анализ обязанности следующего хода во избежания проигрыша или обязательный выигрыш
}
