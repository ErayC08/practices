package com.example.rps;

import com.example.game.GameResult;

public enum GameObject {
    ROCK {
        @Override
        public GameResult computeGameResult(GameObject other) {
            if (other == null) {
                throw new IllegalArgumentException();
            }
            if (other == this) {
                return GameResult.DRAW;
            }
            if (other == PAPER) {
                return GameResult.LOSS;
            }
            return GameResult.WIN;
        }
    }, PAPER {
        @Override
        public GameResult computeGameResult(GameObject other) {
            if (other == null) {
                throw new IllegalArgumentException();
            }
            if (other == this) {
                return GameResult.DRAW;
            }
            if (other == SCISSORS) {
                return GameResult.LOSS;
            }
            return GameResult.WIN;
        }
    }, SCISSORS {
        @Override
        public GameResult computeGameResult(GameObject other) {
            if (other == null) {
                throw new IllegalArgumentException();
            }
            if (other == this) {
                return GameResult.DRAW;
            }
            if (other == ROCK) {
                return GameResult.LOSS;
            }
            return GameResult.WIN;
        }
    };

    public abstract GameResult computeGameResult(GameObject counter);
}
