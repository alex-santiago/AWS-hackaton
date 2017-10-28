package com.hart.team.battleship;

import java.util.Random;

public class ShipPositionGenerator {

    private int matrix_rows;
    private int matrix_columns;

    private String[] ship1 = {"A1","B1"};
    private String[] ship2 = {"A2","B2"};
    private String[] ship3 = {"A3","B3","C3"};
    private String[] fullSpots = {"-","-","-","-","-"};

    private Random rand = new Random();

    public ShipPositionGenerator(int boardRows, int boardColumns) {
        this.matrix_rows = boardRows;
        this.matrix_columns = boardColumns;
    }

    public void RandomizePositions() {

        for (int i=0; i<4; i+=2) {
            int direction = rand.nextInt(2) + 1;
            String[] placeResult;

            if (direction == 1) //vertical
                placeResult = PlaceShip(true, i);
            else
                placeResult = PlaceShip(false, i);

            if(i == 0 || i == 1)
                ship1 = placeResult;
            else  {
                 ship2 = placeResult;
            }
        }
    }

    private String[] PlaceShip(boolean vertical, int positionNumber) {

        String position;
        int column;
        int row;
        String[] ship={"",""};

        do {
            column = rand.nextInt(5) + 1;
            row = rand.nextInt(5) + 1;
            if(vertical)
                position = String.format("%s%s", column, row);
            else
                position = String.format("%s%s", row, column);
        } while (IsPositionFree(position) == false);

        ship[positionNumber] = position;
        fullSpots[positionNumber] = position;
        positionNumber++;
        if(row == 5) {
            if(vertical)
                position = String.format("%s%s", column, row-1);
            else
                position = String.format("%s%s", row, column-1);

            ship[positionNumber] = position;
        }
        else {
            if(vertical)
                position = String.format("%s%s", column, row+1);
            else
                position = String.format("%s%s", row, column+1);
            ship[positionNumber] = position;
        }

        fullSpots[positionNumber] = position;
        return  ship;
    }

    private boolean IsPositionFree(String position) {

        for (int i=0; i<5; i++) {
            if(fullSpots[i] == position) {
                return false;
            }
        }

        return true;
    }

    private String[] GetShip(int position) {

        if(position == 0 || position == 1)
            return ship1;
        else if(position == 2 || position == 3) {
            return  ship2;
        }
        else
            return ship3;
    }


}
