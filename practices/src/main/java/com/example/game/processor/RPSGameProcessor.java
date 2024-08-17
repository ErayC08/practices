package com.example.game.processor;

import com.example.game.object.RPSGameObject;
import com.example.game.common.GameResult;

public class RPSGameProcessor {
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;

    public void computeResult(RPSGameObject playerMove, RPSGameObject computerMove) {
        GameResult status = playerMove.computeResult(computerMove);

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
