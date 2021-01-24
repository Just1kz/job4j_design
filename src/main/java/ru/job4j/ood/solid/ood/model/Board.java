package ru.job4j.ood.solid.ood.model;

import ru.job4j.ood.solid.ood.input.InputManager;
import ru.job4j.ood.solid.ood.output.OutputManager;
import ru.job4j.ood.solid.ood.rules.RulesManager;

public class Board implements GameManager {
    private final String[][] gameTable = new String[3][3];
    private final Player player1;
    private final Player player2;
    private final InputManager input;
    private final OutputManager output;
    private final RulesManager rules;
    private String winMark = "Ничья! Победила Дружба! =)";
    private int steps = 1;


    public Board(Player player1, Player player2, InputManager input, OutputManager output, RulesManager rules) {
        this.player1 = player1;
        this.player2 = player2;
        this.input = input;
        this.output = output;
        this.rules = rules;
    }

    public int getSteps() {
        return steps;
    }

    //первичное представление и правила игры
    @Override
    public void gameRules() {
        output.println("Добро пожаловать в игру - \"Крестики-Нолики\", правила очень просты: ");
        output.println("1. Первый ход осуществляется в центр;");
        output.println("2. Если игрок может немедленно выиграть, он это делает;");
        output.println("3. Если игрок не может немедленно выиграть, но его противник мог бы немедленно выиграть, сделав ход в какую-то клетку, "
                + "игрок сам делает ход в эту клетку, предотвращая немедленный проигрыш;");
        output.println("4. Выигрывает тот игрок, который первым соберёт 3 символа подрят по диагонали/горизонтали/вертикали;");
        rulesTable(gameTable);
        setGameTable(gameTable);
        output.println("");
        output.println("Пожалуйста задайте настроки Игры (Имена игроков и символы(Х и О соотвественно)) согласно шаблона - "
                + "Имя1ПробелСимволЗапятаяПробелИмя2ПробелСимвол ->");
    }

    //задание параметров игры для каждого пользователя
    @Override
    public void gameSettings() {
        String[] player1Settings;
        String[] player2Settings;
        do {
            String[] settings = input.splitAsk(input.ask(), ", ");
            player1Settings = settings[0].split(" ");
            player2Settings = settings[1].split(" ");
            if (player1Settings.length != 2
                    && player2Settings.length != 2) {
                output.println("Вы ввели неверные найстроки, проверьте введенные данные, "
                        + "чтобы они соответствовали шаблону - Имя1ПробелСимволЗапятаяПробелИмя2ПробелСимвол");
            }
        } while (player1Settings.length != 2
                && player2Settings.length != 2);

            player1.setName(player1Settings[0]);
            player1.setMark(player1Settings[1].toLowerCase());
            player2.setName(player2Settings[0]);
            player2.setMark(player2Settings[1].toLowerCase());
            output.println(player1.getName() + " играет символом -  " + player1.getMark());
            output.println(player2.getName() + " играет символом -  " + player2.getMark());
            output.println("Прошу соблюдать правила игры и играть своими символами!");
            output.println("При совершении ходов необходимо соблюдать шаблон -> ");
            output.println("!!!НомерЯчейкиТаблицыПРОБЕЛСимвол(символ - Русскими ЗАГЛАВНЫМИ буквами)!!!, согласно таблице ниже: ");
    }

    //визуализация для правил игры
    void rulesTable(String[][] x) {
        int z = 0;
        for (int i = 0; i < x.length; i++) {
            if (i > 0) {
                System.out.println();
            }
            for (int y = 0; y < x[i].length; y++) {
                z++;
                if (x[i][y] == null) {
                    x[i][y] = " " + z + " ";
                }
                if (y == x[i].length - 1) {
                    System.out.print("[" + x[i][y] + "]");
                } else {
                    System.out.print("[" + x[i][y] + "] | ");
                }
            }
        }
    }

    //подготовка таблицы для игры
    void setGameTable(String[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int y = 0; y < x[i].length; y++) {
                    x[i][y] = "   ";
            }
        }
    }

    //обработка хода игроком с учётом правил
    boolean step() throws Exception {
        int index;
        String mark;
        do {
            String step = input.ask();
            String[] p = input.splitAsk(step, " ");
            index = Integer.parseInt(p[0]);
            mark = p[1].toLowerCase();
            if (steps == 1 && !rules.firstStep(index)) {
                output.println("Совершая первых ход, вы нарушаете правила игры, произведите ход в центр таблицы");
            }
            if (index <= 0 || index > 9) {
                output.println("Вы делаете ход в неверном формате! Повторите");
            }
            if ((rules.rulesQueue(steps) == 1 || steps == 1)
                    && !rules.checkSymbol(mark, player1)) {
                output.println("Вы делаете ход не своим символом! Повторите");
            }
            if ((rules.rulesQueue(steps) == 2)
                    && !rules.checkSymbol(mark, player2)) {
                output.println("Вы делаете ход не своим символом! Повторите");
            }
            if ((rules.rulesQueue(steps) == 1 || steps == 1)
                    && rules.analyzeNextStep(gameTable, player1) > 0
                    && rules.analyzeNextStep(gameTable, player1) != index) {
                output.println("Вы не пытаетесь предотвратить своё поражение и нарушаете правила игры!");
                output.println("Произведите ход в ячейку номер: " + rules.analyzeNextStep(gameTable, player1));
            }
            if (rules.rulesQueue(steps) == 2
                    && rules.analyzeNextStep(gameTable, player2) > 0
                    && rules.analyzeNextStep(gameTable, player2) != index) {
                output.println("Вы не пытаетесь предотвратить своё поражение и нарушаете правила игры!");
                output.println("Произведите ход в ячейку номер: " + rules.analyzeNextStep(gameTable, player2));
            }
        } while ((index <= 0 || index > 9)
                || (steps == 1 && !rules.firstStep(index))
                || ((rules.rulesQueue(steps) == 1 || steps == 1)
                        && !mark.equals(player1.getMark()))
                || (rules.rulesQueue(steps) == 2
                        && !mark.equals(player2.getMark()))
                || ((rules.rulesQueue(steps) == 1 || steps == 1)
                        && rules.analyzeNextStep(gameTable, player1) > 0
                        &&  rules.analyzeNextStep(gameTable, player1) != index)
                || (rules.rulesQueue(steps) == 2
                        && rules.analyzeNextStep(gameTable, player2) > 0
                        && rules.analyzeNextStep(gameTable, player2) != index));

        int count = 0;
        for (int i = 0; i < gameTable.length; i++) {
            for (int y = 0; y < gameTable[i].length; y++) {
                count++;
                if (count == index) {
                    if (!rules.analyzeStep(gameTable[i][y])) {
                        output.println("Вы пытаетесь сделать ход в занятую ячейку");
                        return false;
                    }
                    gameTable[i][y] = " " + mark + " ";
                    steps++;
                    break;
                }
            }
        }
        return true;
    }

    //Игра
    @Override
    public void gamePlay() throws Exception {
        gameRules();
        gameSettings();
        output.println("Игра началась!");
        output.printTable(gameTable);
        while (resultGame()) {
                    if (rules.rulesQueue(steps) == 1 || steps == 1) {
                        //first
                        output.println("Сделайте свой ход: " + player1.getName());
                    } else {
                        output.println("Сделайте свой ход: " + player2.getName());
                        //second
                    }
            if (step()) {
                output.println("Ход выполнен!");
                output.printTable(gameTable);
            }
        }

        output.println("Игра окончена!");
        if (winMark.contains("Ничья")) {
            output.println(winMark);
        }
        if (winMark.equals(player1.getMark().toLowerCase())) {
            output.println("Победитель -> " + player1.getName());
        }
        if (winMark.equals(player2.getMark().toLowerCase())) {
            output.println("Победитель -> " + player2.getName());
        }
        output.println("");
        output.println("Хотите сыграть снова?");
        String again = input.ask().toLowerCase();
        if (again.equals("да")) {
            gamePlay();
        } else {
            output.println("Спасибо за игру! Будем ждать вас снова!");
        }
    }

    //проверка совпадения и свободных ячеек
    @Override
    public boolean resultGame() {
        String x = "х";
        String o = "о";
        if (checkHorizontalWinMark(gameTable, o)
                || checkVerticalWinMark(gameTable, o)
                || checkDiagonalWinMark(gameTable, o)) {
            winMark = o;
            return false;
        }
        if (checkHorizontalWinMark(gameTable, x)
                || checkVerticalWinMark(gameTable, x)
                || checkDiagonalWinMark(gameTable, x)) {
            winMark = x;
            return false;
        }
        if (!checkFreePlaceOnGameTable(gameTable)) {
            return false;
        }
        return true;
    }

    boolean checkHorizontalWinMark(String[][] x, String mark) {
        for (String[] strings : x) {
            for (int y = 0; y < strings.length; y++) {
                if (x[0][0].contains(mark) && x[0][1].contains(mark) && x[0][2].contains(mark)) {
                    return true;
                }
                if (x[1][0].contains(mark) && x[1][1].contains(mark) && x[1][2].contains(mark)) {
                    return true;
                }
                if (x[2][0].contains(mark) && x[2][1].contains(mark) && x[2][2].contains(mark)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkVerticalWinMark(String[][] x, String mark) {
        for (String[] strings : x) {
            for (int y = 0; y < strings.length; y++) {
                if (x[0][0].contains(mark) && x[1][0].contains(mark) && x[2][0].contains(mark)) {
                    return true;
                }
                if (x[0][1].contains(mark) && x[1][1].contains(mark) && x[2][1].contains(mark)) {
                    return true;
                }
                if (x[0][2].contains(mark) && x[1][2].contains(mark) && x[2][2].contains(mark)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkDiagonalWinMark(String[][] x, String mark) {
        for (String[] strings : x) {
            for (int y = 0; y < strings.length; y++) {
                if (x[0][0].contains(mark) && x[1][1].contains(mark) && x[2][2].contains(mark)) {
                    return true;
                }
                if (x[0][2].contains(mark) && x[1][1].contains(mark) && x[2][0].contains(mark)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean checkFreePlaceOnGameTable(String[][] x) {
        int rsl = 0;
        for (String[] strings : x) {
            for (String string : strings) {
                if (rules.analyzeStep(string)) {
                    rsl++;
                }
            }
        }
        return rsl > 0;
    }
}
