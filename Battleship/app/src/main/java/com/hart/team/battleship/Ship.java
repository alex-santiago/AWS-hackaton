package com.hart.team.battleship;
import java.util.*;


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

        return (Hits.contains(ShipPositions[0]) && Hits.contains(ShipPositions[1]));
    }

    public ArrayList<String> Hits = new ArrayList<>();

    public boolean GotHit(int row, int column) {
        String hit = row+","+column;
        if(Arrays.asList(ShipPositions).contains(hit)){
            Hits.add(hit);
            return true;
        }
        else
            return false;
    }
}
