package com.alejandrosanchez.thegameofpig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button hold;

    private final dice dice = new dice();

    private TextView winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        winner = findViewById(R.id.player_winner);
        winner.setVisibility(View.INVISIBLE);

        Button roll = findViewById(R.id.roll_button);
        Button new_game = findViewById(R.id.new_game_button);
        hold = findViewById(R.id.hold_button);



        }
    }
