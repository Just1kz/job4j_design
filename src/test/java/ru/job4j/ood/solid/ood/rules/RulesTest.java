package ru.job4j.ood.solid.ood.rules;

import org.junit.Rule;
import org.junit.Test;
import ru.job4j.ood.solid.ood.input.ConsoleInput;
import ru.job4j.ood.solid.ood.input.InputManager;
import ru.job4j.ood.solid.ood.model.Board;
import ru.job4j.ood.solid.ood.model.GameManager;
import ru.job4j.ood.solid.ood.model.Player;
import ru.job4j.ood.solid.ood.output.ConsoleOutput;
import ru.job4j.ood.solid.ood.output.OutputManager;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class RulesTest {
    Player player1 = new Player();
    Player player2 = new Player();
    InputManager input = new ConsoleInput();
    OutputManager output = new ConsoleOutput();
    Rules rules = new Rules();
    GameManager board = new Board(player1, player2, input, output, rules);
    String[][] horizontal1 = {{"х", "х", "   "},
                                                    {"   ", "   ", "   "},
                                                    {"   ", "   ", "   "}};
    String[][] horizontal2 = {{"   ", "х", "х"},
                                                    {"   ", "   ", "   "},
                                                    {"   ", "   ", "   "}};
    String[][] vertical = {{"х", "   ", "   "},
                                            {"х", "   ", "   "},
                                            {"   ", "   ", "   "}};
    String[][] vertical2 = {{"   ", "   ", "   "},
                                                {"х", "   ", "   "},
                                                {"х", "   ", "   "}};
    String[][] diagonal1 = {{"   ", "   ", "   "},
                                                {"   ", "х", "   "},
                                                {"   ", "   ", "х"}};
    String[][] diagonal2 = {{"х", "   ", "   "},
                                                {"   ", "х", "   "},
                                                {"   ", "   ", "   "}};
    String[][] firstStep = {{"   ", " о ", "   "},
                                              {"   ", "   ", "   "},
                                              {"   ", "   ", "   "}};

    @Test
    public void analyzeNextStep() {
        player1.setMark("о");
        assertThat(rules.analyzeNextStep(horizontal1, player1), is(3));
    }

    @Test
    public void checkHorizontalMark() {
        assertThat(rules.checkHorizontalMark(horizontal1, "о"), is(3));
        assertThat(rules.checkHorizontalMark(horizontal2, "о"), is(1));
    }

    @Test
    public void checkVerticalMark() {
        assertThat(rules.checkVerticalMark(vertical, "о"), is(7));
        assertThat(rules.checkVerticalMark(vertical2, "о"), is(1));
    }

    @Test
    public void checkDiagonalMark() {
        assertThat(rules.checkDiagonalMark(diagonal1, "о"), is(1));
        assertThat(rules.checkDiagonalMark(diagonal2, "о"), is(9));
    }

    @Test
    public void analyzeStep() {
        assertThat(rules.analyzeStep(firstStep[0][0]), is(true));
        assertThat(rules.analyzeStep(firstStep[0][1]), is(false));
    }

    @Test
    public void firstStep() {
        assertThat(rules.firstStep(7), is(false));
        assertThat(rules.firstStep(5), is(true));
    }

    @Test
    public void rulesQueue() {
        assertThat(rules.rulesQueue(board.getSteps()), is(1));
        assertThat(rules.rulesQueue(3), is(1));
        assertThat(rules.rulesQueue(4), is(2));
    }

    @Test
    public void checkSymbol() {
        player1.setMark("х");
        String markInput = "х";
        assertThat(rules.checkSymbol(markInput, player1), is(true));
    }
}