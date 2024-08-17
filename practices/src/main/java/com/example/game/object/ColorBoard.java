package com.example.game.object;

import com.example.game.exception.IllegalColorArgumentException;

public abstract class ColorBoard {
    private final Color[][] colors;

    public ColorBoard(int rows, int cols) {
        this.colors = new Color[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.colors[i][j] = Color.NONE;
            }
        }
    }

    public Color getColor(int rowIndex, int colIndex) {
        try {
            return this.colors[rowIndex][colIndex];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public void setColor(int rowIndex, int colIndex, Color color) {
        if (color == null || color == Color.NONE) {
            throw new IllegalColorArgumentException();
        }
        this.colors[rowIndex][colIndex] = color;
    }

    public abstract boolean involvesLine(int rowIndex, int colIndex, int length);

    protected boolean involvesHorizontalLine(int rowIndex, int colIndex, int length) {
        boolean involvesHorizontalLineWestSide = true;
        boolean involvesHorizontalLineEastSide = true;

        Color center = this.getColor(rowIndex, colIndex);

        for (int i = 1; i < length; i++) {
            Color nextEastSide = this.getColor(rowIndex, colIndex + i);
            Color nextWestSide = this.getColor(rowIndex, colIndex - i);

            if (nextWestSide != center) {
                involvesHorizontalLineWestSide = false;
            }
            if (nextEastSide != center) {
                involvesHorizontalLineEastSide = false;
            }
        }
        return involvesHorizontalLineEastSide || involvesHorizontalLineWestSide;
    }

    protected boolean involvesVerticalLine(int rowIndex, int colIndex, int length) {
        boolean involvesVerticalLineSouthSide = true;
        boolean involvesVerticalLineNorthSide = true;

        Color center = this.getColor(rowIndex, colIndex);

        for (int i = 1; i < length; i++) {
            Color nextNorthSide = this.getColor(rowIndex - i, colIndex);
            Color nextSouthSide = this.getColor(rowIndex + i, colIndex);

            if (nextSouthSide != center) {
                involvesVerticalLineSouthSide = false;
            }
            if (nextNorthSide != center) {
                involvesVerticalLineNorthSide = false;
            }
        }
        return involvesVerticalLineNorthSide || involvesVerticalLineSouthSide;
    }

    protected boolean involvesDiagonalLine(int rowIndex, int colIndex, int length) {
        boolean involvesDiagonalLineSouthWestSide = true;
        boolean involvesDiagonalLineNorthWestSide = true;
        boolean involvesDiagonalLineNorthEastSide = true;
        boolean involvesDiagonalLineSouthEastSide = true;

        Color center = this.getColor(rowIndex, colIndex);

        for (int i = 1; i < length; i++) {
            Color nextSouthWestSide = this.getColor(rowIndex + i, colIndex - i);
            Color nextNorthWestSide = this.getColor(rowIndex - i, colIndex - i);
            Color nextNorthEastSide = this.getColor(rowIndex - i, colIndex + i);
            Color nextSouthEastSide = this.getColor(rowIndex + i, colIndex + i);

            if (nextSouthEastSide != center) {
                involvesDiagonalLineSouthEastSide = false;
            }
            if (nextNorthEastSide != center) {
                involvesDiagonalLineNorthEastSide = false;
            }
            if (nextNorthWestSide != center) {
                involvesDiagonalLineNorthWestSide = false;
            }
            if (nextSouthWestSide != center) {
                involvesDiagonalLineSouthWestSide = false;
            }
        }
        return involvesDiagonalLineSouthWestSide || involvesDiagonalLineNorthWestSide || involvesDiagonalLineNorthEastSide || involvesDiagonalLineSouthEastSide;
    }
}
