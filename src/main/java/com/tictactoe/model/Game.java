package com.tictactoe.model;

public class Game {
    private int[][] chessBoard = new int[3][3];

    public void player1add(int x, int y) {
        if (chessBoard[x][y] != 0)
            throw new ConflictStepException();
        chessBoard[x][y] = 1;
    }

    public int winner() {
        if (isOneWin()) return 1;
        if (isTwoWin()) return 2;

        return 0;
    }

    private boolean isTwoWin() {
        return isWin(-3);
    }

    private boolean isOneWin() {
        return isWin(3);
    }

    private boolean isWin(int target) {
        return row(target) || column(target) || cross(target) || backCross(target);
    }

    private boolean backCross(int target) {
        int result = chessBoard[2][0] + chessBoard[1][1] + chessBoard[0][2];
        return result == target;
    }

    private boolean cross(int target) {
        int result = chessBoard[0][0] + chessBoard[1][1] + chessBoard[2][2];
        return result == target;
    }

    private boolean column(int result) {
        for (int i = 0; i < 3; i ++){
            if (chessBoard[0][i] + chessBoard[1][i] + chessBoard[2][i] == result)
                return true;
        }
        return false;
    }

    private boolean row(int result) {
        for (int i = 0; i < 3; i ++){
            if (chessBoard[i][0] + chessBoard[i][1] + chessBoard[i][2] == result)
                return true;
        }
        return false;
    }

    public void player2add(int x, int y) {
        chessBoard[x][y] = -1;
    }
}
