package com.example.game.object;

public enum Color {
    RED, YELLOW, NONE;

    public char getSymbol() {
        return this.toString().charAt(0);
    };
}
