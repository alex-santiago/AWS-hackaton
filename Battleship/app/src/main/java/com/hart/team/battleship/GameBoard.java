package com.hart.team.battleship;

/**
 * Created by alexandresilva on 2017-11-04.
 */

public class GameBoard {

    public enum cell {
        Miss,
        Hit,
        Empty
    }

    private final int BOARD_SIZE = 5;
    private final int MAX_AMMO = 15;

    public int AmmoUsed;
    public int AmmoAvailable;

    private cell[][] board;
    private Ship[] Ships;
    private int UserScore;

    private Ship Ship1;
    private Ship Ship2;
    private Ship Ship3;

    GameBoard() {
        InitGameBoard();
    }

    public void InitGameBoard () {
        board = new cell[BOARD_SIZE][BOARD_SIZE];

        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                board[row][column] = cell.Empty;
            }
        }

        AmmoUsed = 0;
        AmmoAvailable = MAX_AMMO - AmmoUsed;

        UserScore = 0;

        ShipPositionGenerator shipGenerator = new ShipPositionGenerator(BOARD_SIZE, BOARD_SIZE);

        Ships = shipGenerator.RandomizePositions();

        Ship1 = Ships[0];
        Ship2 = Ships[1];
    }

    public Boolean firePositionValid(int row, int column) {
        if (board[row][column] == cell.Empty) {
            return true;
        }
        else {
            return false;
        }
    }

    private void UpdateAmmo(){
        AmmoUsed =+1;
        AmmoAvailable = MAX_AMMO - AmmoUsed;
    }

    private void UpdateScore(int row, int column){
        if (itIsAHit(row, column)) {
            UserScore =+10;
        }
    }

    public int getUserScore() { return UserScore; }

    public void fireAtPosition(int row, int column) {
        if (itIsAHit(row, column)) {
            board[row][column] = cell.Hit;
            UpdateScore(row,column);
        }
        else {
            board[row][column] = cell.Miss;
        }
        UpdateAmmo();
    }

    public Boolean itIsAHit(int row, int column) {
        if (Ship1.GotHit(row, column)) {
            return true;
        }
        else if (Ship2.GotHit(row, column)) {
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean isGameOver() {
        if (AmmoAvailable == 0) {
            return true;
        }
        else {
            return false;
        }
    }

}
