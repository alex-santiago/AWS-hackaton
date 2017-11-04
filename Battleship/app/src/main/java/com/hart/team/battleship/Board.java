package com.hart.team.battleship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Board extends AppCompatActivity
        implements View.OnClickListener {

    private TextView labelScore;

    private EditText editCommand;

    private Button btnNew;
    private Button btnLeaders;
    private Button btnFire;

    private Button btnA1;
    private Button btnA2;
    private Button btnA3;
    private Button btnA4;
    private Button btnA5;

    private Button btnB1;
    private Button btnB2;
    private Button btnB3;
    private Button btnB4;
    private Button btnB5;

    private Button btnC1;
    private Button btnC2;
    private Button btnC3;
    private Button btnC4;
    private Button btnC5;

    private Button btnD1;
    private Button btnD2;
    private Button btnD3;
    private Button btnD4;
    private Button btnD5;

    private Button btnE1;
    private Button btnE2;
    private Button btnE3;
    private Button btnE4;
    private Button btnE5;

    private int UserScore;

    private String boardRow1;
    private String boardRow2;
    private String boardRow3;
    private String boardRow4;
    private String boardRow5;

    private GameBoard board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        labelScore = findViewById(R.id.labelScore);

        editCommand = findViewById(R.id.editCommand);

        btnNew = findViewById(R.id.btnNew);
        btnLeaders = findViewById(R.id.btnLeaders);
        btnFire = findViewById(R.id.btnFire);

        btnA1 = findViewById(R.id.btnA1);
        btnA2 = findViewById(R.id.btnA2);
        btnA3 = findViewById(R.id.btnA3);
        btnA4 = findViewById(R.id.btnA4);
        btnA5 = findViewById(R.id.btnA5);

        btnB1 = findViewById(R.id.btnB1);
        btnB2 = findViewById(R.id.btnB2);
        btnB3 = findViewById(R.id.btnB3);
        btnB4 = findViewById(R.id.btnB4);
        btnB5 = findViewById(R.id.btnB5);

        btnC1 = findViewById(R.id.btnC1);
        btnC2 = findViewById(R.id.btnC2);
        btnC3 = findViewById(R.id.btnC3);
        btnC4 = findViewById(R.id.btnC4);
        btnC5 = findViewById(R.id.btnC5);

        btnD1 = findViewById(R.id.btnD1);
        btnD2 = findViewById(R.id.btnD2);
        btnD3 = findViewById(R.id.btnD3);
        btnD4 = findViewById(R.id.btnD4);
        btnD5 = findViewById(R.id.btnD5);

        btnE1 = findViewById(R.id.btnE1);
        btnE2 = findViewById(R.id.btnE2);
        btnE3 = findViewById(R.id.btnE3);
        btnE4 = findViewById(R.id.btnE4);
        btnE5 = findViewById(R.id.btnE5);

        btnNew.setOnClickListener(this);
        btnLeaders.setOnClickListener(this);
        btnFire.setOnClickListener(this);

        btnA1.setOnClickListener(this);
        btnA2.setOnClickListener(this);
        btnA3.setOnClickListener(this);
        btnA4.setOnClickListener(this);
        btnA5.setOnClickListener(this);

        btnB1.setOnClickListener(this);
        btnB2.setOnClickListener(this);
        btnB3.setOnClickListener(this);
        btnB4.setOnClickListener(this);
        btnB5.setOnClickListener(this);

        btnC1.setOnClickListener(this);
        btnC2.setOnClickListener(this);
        btnC3.setOnClickListener(this);
        btnC4.setOnClickListener(this);
        btnC5.setOnClickListener(this);

        btnD1.setOnClickListener(this);
        btnD2.setOnClickListener(this);
        btnD3.setOnClickListener(this);
        btnD4.setOnClickListener(this);
        btnD5.setOnClickListener(this);

        btnE1.setOnClickListener(this);
        btnE2.setOnClickListener(this);
        btnE3.setOnClickListener(this);
        btnE4.setOnClickListener(this);
        btnE5.setOnClickListener(this);

        board = new GameBoard();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnA1:
                MarkBoard(btnA1, 0, 0);
                break;
            case R.id.btnA2:
                MarkBoard(btnA2, 1, 0);
                break;
            case R.id.btnA3:
                MarkBoard(btnA3, 2, 0);
                break;
            case R.id.btnA4:
                MarkBoard(btnA4, 3, 0);
                break;
            case R.id.btnA5:
                MarkBoard(btnA5, 4, 0);
                break;

            case R.id.btnB1:
                MarkBoard(btnB1, 0, 1);
                break;
            case R.id.btnB2:
                MarkBoard(btnB2, 1, 1);
                break;
            case R.id.btnB3:
                MarkBoard(btnB3, 2, 1);
                break;
            case R.id.btnB4:
                MarkBoard(btnB4, 3, 1);
                break;
            case R.id.btnB5:
                MarkBoard(btnB5, 4, 1);
                break;

            case R.id.btnC1:
                MarkBoard(btnC1, 0, 2);
                break;
            case R.id.btnC2:
                MarkBoard(btnC2, 1, 2);
                break;
            case R.id.btnC3:
                MarkBoard(btnC3, 2, 2);
                break;
            case R.id.btnC4:
                MarkBoard(btnC4, 3, 2);
                break;
            case R.id.btnC5:
                MarkBoard(btnC5, 4, 2);
                break;

            case R.id.btnD1:
                MarkBoard(btnD1, 0, 3);
                break;
            case R.id.btnD2:
                MarkBoard(btnD2, 1, 3);
                break;
            case R.id.btnD3:
                MarkBoard(btnD3, 2, 3);
                break;
            case R.id.btnD4:
                MarkBoard(btnD4, 3, 3);
                break;
            case R.id.btnD5:
                MarkBoard(btnD5, 4, 3);
                break;

            case R.id.btnE1:
                MarkBoard(btnE1, 0, 4);
                break;
            case R.id.btnE2:
                MarkBoard(btnE2, 1, 4);
                break;
            case R.id.btnE3:
                MarkBoard(btnE3, 2, 4);
                break;
            case R.id.btnE4:
                MarkBoard(btnE4, 3, 4);
                break;
            case R.id.btnE5:
                MarkBoard(btnE5, 4, 4);
                break;

            case R.id.btnFire:
                PassCommand();
                break;

            case R.id.btnNew:
                InitGameBoard();
                break;
            case R.id.btnLeaders:
                Intent intent = new Intent("com.hart.team.battleship.LeaderBoard");
                startActivity(intent);
                break;
        }
    }

    protected void InitGameBoard () {
        labelScore.setText("0");

        editCommand.setText("");

        btnA1.setText("");
        btnA2.setText("");
        btnA3.setText("");
        btnA4.setText("");
        btnA5.setText("");

        btnB1.setText("");
        btnB2.setText("");
        btnB3.setText("");
        btnB4.setText("");
        btnB5.setText("");

        btnC1.setText("");
        btnC2.setText("");
        btnC3.setText("");
        btnC4.setText("");
        btnC5.setText("");

        btnD1.setText("");
        btnD2.setText("");
        btnD3.setText("");
        btnD4.setText("");
        btnD5.setText("");

        btnE1.setText("");
        btnE2.setText("");
        btnE3.setText("");
        btnE4.setText("");
        btnE5.setText("");

    }

    protected void PassCommand () {

    }

    protected void MarkBoard(Button btn, int row, int column) {
        if (! board.isGameOver()) {
            if (board.firePositionValid(row, column)) {
                board.fireAtPosition(row, column);
                if (board.itIsAHit(row, column)) {
                    btn.setText("HIT");
                    labelScore.setText(board.getUserScore());
                    Toast.makeText(this,
                            "It is a HIT.",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    btn.setText("Miss");
                    Toast.makeText(this,
                            "It is a MISS.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
        else {
            Toast.makeText(this,
                    "Game Over. Start a new game.",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
