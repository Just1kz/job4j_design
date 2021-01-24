package ru.job4j.ood.solid.ood.rules;

import ru.job4j.ood.solid.ood.model.Player;

public class Rules implements RulesManager {
    private int countSteps = 0;

    public int getCountSteps() {
        return countSteps;
    }

    public void setCountSteps(int countSteps) {
        this.countSteps = countSteps;
    }

    public int analyzeNextStep(String[][] x, Player player) {
        String mark = player.getMark().toLowerCase();
        int nextStep;
        nextStep = checkHorizontalMark(x, mark);
        if (nextStep == 0) {
            nextStep = checkVerticalMark(x, mark);
        }
        if (nextStep == 0) {
            nextStep = checkDiagonalMark(x, mark);
        }
        return nextStep;
    }

    int checkHorizontalMark(String[][] x, String mark) {
        String markFind = "";
        int rsl = 0;
        if (mark.equals("х")) {
            markFind = "о";
        }
        if (mark.equals("о")) {
            markFind = "х";
        }
        for (String[] strings : x) {
            for (int y = 0; y < strings.length; y++) {
                if (x[0][2].contains(markFind) && x[0][1].contains(markFind) && analyzeStep(x[0][0])) {
                    rsl = 1;
                }
                if (x[0][0].contains(markFind) && x[0][1].contains(markFind) && analyzeStep(x[0][2])) {
                    rsl = 3;
                }
                if (x[1][2].contains(markFind) && x[1][1].contains(markFind) && analyzeStep(x[1][0])) {
                    rsl = 4;
                }
                if (x[1][0].contains(markFind) && x[1][1].contains(markFind) && analyzeStep(x[1][2])) {
                    rsl = 6;
                }
                if (x[2][0].contains(markFind) && x[2][1].contains(markFind) && analyzeStep(x[2][2])) {
                    rsl = 9;
                }
                if (x[2][2].contains(markFind) && x[2][1].contains(markFind) && analyzeStep(x[2][0])) {
                    rsl = 7;
                }
            }
        }
        return rsl;
    }

    int checkVerticalMark(String[][] x, String mark) {
        String markFind = "";
        int rsl = 0;
        if (mark.equals("х")) {
            markFind = "о";
        }
        if (mark.equals("о")) {
            markFind = "х";
        }
        for (String[] strings : x) {
            for (int y = 0; y < strings.length; y++) {
                if (x[2][0].contains(markFind) && x[1][0].contains(markFind) && analyzeStep(x[0][0])) {
                    rsl = 1;
                }
                if (x[0][0].contains(markFind) && x[1][0].contains(markFind) && analyzeStep(x[2][0])) {
                    rsl = 7;
                }
                if (x[2][1].contains(markFind) && x[1][1].contains(markFind) && analyzeStep(x[0][1])) {
                    rsl = 2;
                }
                if (x[0][1].contains(markFind) && x[1][1].contains(markFind) && analyzeStep(x[2][1])) {
                    rsl = 8;
                }
                if (x[2][2].contains(markFind) && x[1][2].contains(markFind) && analyzeStep(x[0][2])) {
                    rsl = 3;
                }
                if (x[0][2].contains(markFind) && x[1][2].contains(markFind) && analyzeStep(x[2][2])) {
                    rsl = 9;
                }
            }
        }
        return rsl;
    }

    int checkDiagonalMark(String[][] x, String mark) {
        String markFind = "";
        int rsl = 0;
        if (mark.equals("х")) {
            markFind = "о";
        }
        if (mark.equals("о")) {
            markFind = "х";
        }
        for (String[] strings : x) {
            for (int y = 0; y < strings.length; y++) {
                if (x[0][0].contains(markFind) && x[1][1].contains(markFind) && analyzeStep(x[2][2])) {
                    rsl = 9;
                }
                if (x[2][2].contains(markFind) && x[1][1].contains(markFind) && analyzeStep(x[0][0])) {
                    rsl = 1;
                }
                if (x[0][2].contains(markFind) && x[1][1].contains(markFind) && analyzeStep(x[2][0])) {
                    rsl = 7;
                }
                if (x[2][0].contains(markFind) && x[1][1].contains(markFind) && analyzeStep(x[0][2])) {
                    rsl = 3;
                }
            }
        }
        return rsl;
    }

    @Override
    public boolean analyzeStep(String x) {
        return x.equals("   ");
    }

    public boolean firstStep(int x) {
        return x == 5;
    }

    @Override
    public int rulesQueue(int x) {
        int rsl;
        if (x % 2 == 0) {
            rsl = 2;
        } else {
            rsl = 1;
        }
        return rsl;
    }

    public boolean checkSymbol(String x, Player player) {
        return player.getMark().equals(x);
    }
}
