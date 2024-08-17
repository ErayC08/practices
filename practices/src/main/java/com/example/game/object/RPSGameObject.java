package com.example.game.object;

import com.example.game.common.GameResult;

public enum RPSGameObject {
    ROCK {
        @Override
        public GameResult computeResult(RPSGameObject other) {
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
        public GameResult computeResult(RPSGameObject other) {
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
        public GameResult computeResult(RPSGameObject other) {
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

    public abstract GameResult computeResult(RPSGameObject other);
}
