package com.alejandrosanchez.thegameofpig;

import java.util.HashMap;

public class dice {
    private HashMap<String, Integer> players = new HashMap<>();

    private boolean hold = false;

    private static int scoreRound = 0;

    public dice() {
        players.put("p1", 0);
        players.put("p2", 0);
    }

    public static int roll() {
        return (int) (Math.random() * 6) + 1;
    }

    public void play() {
        int number = 0;

        if (!((number = roll()) == 1)) {
            scoreRound += number;
        } else {
            this.hold(this.invertedHold());
            scoreRound = 0;
        }

    }

    public String winner(){
        String winner = "";
        if (players.get("p1") >= 100) {
            winner = "Player 1";
        } else if (players.get("p2") >= 100) {
            winner = "Player 2";
        }
        return winner;
    }
    public void deleteGame(){
        players.put("p1", 0);
        players.put("p2", 0);
        scoreRound = 0;
    }

    public static void setScoreRound(int scoreRound) {
        dice.scoreRound = scoreRound;
    }
    public int getScoreRound(){
        return scoreRound;
    }
    public int getPoints(String player){
        Integer points = players.get(player);
        return points != null ? points : 0;
    }
    public void addDice(String player, int roll){
        players.merge(player, roll, Integer::sum);
    }

    private void hold(boolean hold) {
        this.hold = hold;
    }

    private boolean invertedHold() {
        return !hold;
    }
}