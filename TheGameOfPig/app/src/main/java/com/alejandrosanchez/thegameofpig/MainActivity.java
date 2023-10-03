package com.alejandrosanchez.thegameofpig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button hold;

    private final Dice dice = new Dice();

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

        private void setGameHold(){
        hold.setOnClickListener(view -> {

            if (dice.invertedHold()){
                dice.sumPoints("p1", dice.getScoreRound());
                dice.setScoreRound(0);

                TextView viewPlayer1 = findViewById(R.id.p1_score);
                viewPlayer1.setText(String.valueOf(dice.getPoints("p1")));
            }
        });
        }
    }
