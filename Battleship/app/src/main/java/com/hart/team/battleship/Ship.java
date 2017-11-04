package com.hart.team.battleship;
import java.util.*;
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

    public boolean IsDestroyed() {
        return Hits == this._shipSize;
    }

    public int Hits;

    public boolean GotHit(String hit) {
        if(Arrays.asList(ShipPositions).contains(hit)){
            Hits++;
            return true;
        }
        else
            return false;
    }
}
