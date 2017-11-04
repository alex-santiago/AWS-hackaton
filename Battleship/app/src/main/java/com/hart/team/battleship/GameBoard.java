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

    private int AmmoUsed;
    private int AmmoAvailable;

    private cell[][] board;
    private Ship[] Ships;
    private int UserScore;

    private Ship Ship1;
    private Boolean Ship1Destroyed;
    private Ship Ship2;
    private Boolean Ship2Destroyed;
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
        Ship1Destroyed = false;
        Ship2Destroyed = false;

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
        AmmoUsed +=1;
        AmmoAvailable = MAX_AMMO - AmmoUsed;
    }

    private void UpdateScore(int row, int column){
        if (itIsAHit(row, column)) {
            UserScore +=5;
        }
        if (!Ship1Destroyed) {
            if (Ship1.IsDestroyed()) {
                Ship1Destroyed = true;
                UserScore +=10;
            }

        }
        if (!Ship2Destroyed) {
            if (Ship2.IsDestroyed()) {
                Ship2Destroyed = true;
                UserScore +=10;
            }
        }
        if (isGameOver()){
            UserScore = UserScore + (AmmoAvailable * 10);
        }
    }

    public int getUserScore() { return UserScore; }

    public int getAmmoAvailable() { return AmmoAvailable; }

    public void fireAtPosition(int row, int column) {
        UpdateAmmo();
        if (itIsAHit(row, column)) {
            board[row][column] = cell.Hit;
            UpdateScore(row,column);
        }
        else {
            board[row][column] = cell.Miss;
        }
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
        if ( (AmmoAvailable == 0) || (Ship1.IsDestroyed() && Ship2.IsDestroyed())) {
            return true;
        }
        else {
            return false;
        }
    }

}
