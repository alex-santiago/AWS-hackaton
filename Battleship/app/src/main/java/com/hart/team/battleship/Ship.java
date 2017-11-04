package com.hart.team.battleship;

/**
 * Created by Tiago on 2017-11-04.
 */

public class Ship {

    public Ship() {}

    public Ship(int size, String[] positions) {

        SetShipSize(size);
        ShipPositions = positions;
    }

    private int _shipSize;
    public int GetShipSize()
    {
        return _shipSize;
    }

    public void SetShipSize(int value){
        _shipSize = value;
    }

    public String[] ShipPositions;

    public boolean IsDestroyed;

    public int Hits;
}
