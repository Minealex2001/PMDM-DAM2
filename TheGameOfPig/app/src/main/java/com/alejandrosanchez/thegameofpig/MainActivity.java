package com.alejandrosanchez.thegameofpig;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button hold, newGame, roll;

    private final Dice dice = new Dice();

    private TextView winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        winner = findViewById(R.id.player_winner);
        winner.setVisibility(View.INVISIBLE);

        roll = findViewById(R.id.roll_button);
        newGame = findViewById(R.id.new_game_button);
        hold = findViewById(R.id.hold_button);

        setDiceRoll();
        resetGame(newGame);
        setGameHold();
        }

        private void setGameHold(){
        hold.setOnClickListener(view -> {

            if (dice.invertedHold()){
                dice.addDice("p1", dice.getScoreRound());


                TextView viewPlayer1 = findViewById(R.id.p1_score);
                viewPlayer1.setText(String.valueOf(dice.getPoints("p1")));
            }else {
                dice.addDice("p2", dice.getScoreRound());


                TextView viewPlayer2 = findViewById(R.id.p2_score);
                viewPlayer2.setText(String.valueOf(dice.getPoints("p2")));
            }

            dice.setScoreRound(0);
            TextView scoreView = findViewById(R.id.turn_score);
            scoreView.setText(String.valueOf(Dice.getScoreRound()));

            winnerCheck();

            dice.setHold(dice.invertedHold());


        });
        }

        private void resetGame(Button newGame){
        newGame.setOnClickListener(view -> {
            dice.deleteGame();
            TextView viewPlayer1 = findViewById(R.id.p1_score);
            viewPlayer1.setText(String.valueOf(dice.getPoints("p1")));
            TextView viewPlayer2 = findViewById(R.id.p2_score);
            viewPlayer2.setText(String.valueOf(dice.getPoints("p2")));
            winner.setVisibility(View.INVISIBLE);
        });
        }
        private void setDiceRoll(){
        this.roll.setOnClickListener(view -> {
            dice.play();
            TextView scoreView = findViewById(R.id.turn_score);
            scoreView.setText(String.valueOf(Dice.getScoreRound()));
            winnerCheck();
        });
        }

        private void winnerCheck(){
        if (dice.winner().equalsIgnoreCase("P1")){
            winner.setText(R.string.player1_wins);
            winner.setVisibility(View.VISIBLE);
        }else if(dice.winner().equalsIgnoreCase("P2")){
            winner.setText(R.string.player2_wins);
            winner.setVisibility(View.VISIBLE);
        }
        }
    }
