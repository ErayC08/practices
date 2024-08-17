package com.example.rps;

public class GameProcessor {
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    public void computeGameResult(GameObject playerObject, GameObject computerObject) {
        GameResult status = playerObject.computeGameResult(computerObject);

        if (status == GameResult.WIN) {
            this.wins++;
        }
        if (status == GameResult.LOSS) {
            this.losses++;
        }
        if (status == GameResult.DRAW) {
            this.draws++;
        }
    }

    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public int getDraws() {
        return this.draws;
    }
}
