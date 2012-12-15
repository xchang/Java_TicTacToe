package com.tictactoe.model;

import org.junit.Test;

import static junit.framework.Assert.*;

public class GameTest {
    @Test
    public void should_win_a_game_if_one_player_has_three_in_one_row() {
        Game game = new Game();
        game.player1add(0, 0);
        game.player1add(0, 1);
        game.player1add(0, 2);
        assertEquals(1, game.winner());
    }

    @Test
    public void should_win_a_game_if_one_player_has_three_in_row_one() {
        Game game = new Game();
        game.player1add(1, 0);
        game.player1add(1, 1);
        game.player1add(1, 2);
        assertEquals(1, game.winner());
    }

    @Test
    public void should_not_win_a_game_if_one_player_has_three() {
        Game game = new Game();
        game.player1add(0, 0);
        game.player1add(1, 2);
        game.player1add(2, 2);
        assertEquals(0, game.winner());
    }

    @Test
    public void should_win_a_game_if_player_has_three_in_one_column() {
        Game game = new Game();
        game.player2add(0, 0);
        game.player2add(1, 0);
        game.player2add(2, 0);
        assertEquals(2, game.winner());
    }

    @Test
    public void should_win_a_game_if_player_has_three_in_column_1() {
        Game game = new Game();
        game.player2add(0, 1);
        game.player2add(1, 1);
        game.player2add(2, 1);
        assertEquals(2, game.winner());
    }

    @Test
    public void should_win_a_game_if_player_has_cross() {
        Game game = new Game();
        game.player2add(0, 0);
        game.player2add(1, 1);
        game.player2add(2, 2);
        assertEquals(2, game.winner());
    }

    @Test
    public void should_win_a_game_if_player_has_back_cross() {
        Game game = new Game();
        game.player2add(0, 2);
        game.player2add(1, 1);
        game.player2add(2, 0);
        assertEquals(2, game.winner());
    }

    @Test(expected = ConflictStepException.class)
    public void should_win_a_game_if_two_player_has_back_cross() {
        Game game = new Game();
        game.player2add(0, 2);
        game.player1add(0, 2);
    }
}
