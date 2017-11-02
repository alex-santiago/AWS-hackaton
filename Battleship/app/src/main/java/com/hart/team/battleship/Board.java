package com.hart.team.battleship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Board extends AppCompatActivity {

    int UserScore;

    protected void CalculateScore () {

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
    }
}
