package ru.job4j.ood.solid.ood;

import ru.job4j.ood.solid.ood.input.ConsoleInput;
import ru.job4j.ood.solid.ood.input.InputManager;
import ru.job4j.ood.solid.ood.model.Board;
import ru.job4j.ood.solid.ood.model.GameManager;
import ru.job4j.ood.solid.ood.model.Player;
import ru.job4j.ood.solid.ood.output.ConsoleOutput;
import ru.job4j.ood.solid.ood.output.OutputManager;
import ru.job4j.ood.solid.ood.rules.Rules;
import ru.job4j.ood.solid.ood.rules.RulesManager;

public class Game {
    public static void main(String[] args) throws Exception {
        Player player1 = new Player();
        Player player2 = new Player();
        InputManager input = new ConsoleInput();
        OutputManager output = new ConsoleOutput();
        RulesManager rules = new Rules();
        GameManager gameManager = new Board(player1, player2, input, output, rules);
        gameManager.gamePlay();
        //запуск игры Антон Х, Анна О
        //в конструкторе доски должны быть все интерфейсы и 1 строка на старт игры после неё
    }
}
