package com.example.game.object;

public class ConnectFour extends ColorBoard {

    public ConnectFour() {
        super(6, 7);
    }

    public boolean formsLine(int rowIndex, int colIndex, int length) {
        return super.formsLine(rowIndex, colIndex, 4);
    }
}
