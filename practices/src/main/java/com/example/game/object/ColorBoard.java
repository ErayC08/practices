package com.example.game.object;

import com.example.game.exception.IllegalColorArgumentException;

public class ColorBoard {
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

    public boolean formsLine(int rowIndex, int colIndex, int length) {
        boolean formsHorizontalLine = this.formsHorizontalLine(rowIndex, colIndex, length);
        boolean formsVerticalLine = this.formsVerticalLine(rowIndex, colIndex, length);
        boolean formsDiagonalLine = this.formsDiagonalLine(rowIndex, colIndex, length);

        return formsHorizontalLine || formsVerticalLine || formsDiagonalLine;
    }

    public Color fillColumn(int colIndex, Color color) {
        if (color == null || color == Color.NONE) {
            throw new IllegalColorArgumentException();
        }
        int rows = this.colors.length;

        for (int i = rows - 1; 0 <= i; i--) {
            Color next = this.colors[i][colIndex];

            if (next == Color.NONE) {
                this.colors[i][colIndex] = color;

                return null;
            }
        }
        return color;
    }

    private boolean formsHorizontalLine(int rowIndex, int colIndex, int length) {
        boolean formsHorizontalLineWestSide = true;
        boolean formsHorizontalLineEastSide = true;

        Color middle = this.colors[rowIndex][colIndex];

        for (int i = 1; i < length; i++) {
            try {
                Color nextEastSide = this.colors[rowIndex][colIndex + i];
                Color nextWestSide = this.colors[rowIndex][colIndex - i];

                if (nextWestSide != middle) {
                    formsHorizontalLineWestSide = false;
                }
                if (nextEastSide != middle) {
                    formsHorizontalLineEastSide = false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return formsHorizontalLineEastSide || formsHorizontalLineWestSide;
    }

    private boolean formsVerticalLine(int rowIndex, int colIndex, int length) {
        boolean formsVerticalLineSouthSide = true;
        boolean formsVerticalLineNorthSide = true;

        Color middle = this.colors[rowIndex][colIndex];

        for (int i = 1; i < length; i++) {
            try {
                Color nextNorthSide = this.colors[rowIndex - i][colIndex];
                Color nextSouthSide = this.colors[rowIndex + i][colIndex];

                if (nextSouthSide != middle) {
                    formsVerticalLineSouthSide = false;
                }
                if (nextNorthSide != middle) {
                    formsVerticalLineNorthSide = false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return formsVerticalLineNorthSide || formsVerticalLineSouthSide;
    }

    private boolean formsDiagonalLine(int rowIndex, int colIndex, int length) {
        boolean formsDiagonalLineSouthWestSide = true;
        boolean formsDiagonalLineNorthWestSide = true;
        boolean formsDiagonalLineNorthEastSide = true;
        boolean formsDiagonalLineSouthEastSide = true;

        Color middle = this.colors[rowIndex][colIndex];

        for (int i = 1; i < length; i++) {
            try {
                Color nextSouthWestSide = this.colors[rowIndex + i][colIndex - i];
                Color nextNorthWestSide = this.colors[rowIndex - i][colIndex - i];
                Color nextNorthEastSide = this.colors[rowIndex - i][colIndex + i];
                Color nextSouthEastSide = this.colors[rowIndex + i][colIndex + i];

                if (nextSouthEastSide != middle) {
                    formsDiagonalLineSouthEastSide = false;
                }
                if (nextNorthEastSide != middle) {
                    formsDiagonalLineNorthEastSide = false;
                }
                if (nextNorthWestSide != middle) {
                    formsDiagonalLineNorthWestSide = false;
                }
                if (nextSouthWestSide != middle) {
                    formsDiagonalLineSouthWestSide = false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false;
            }
        }
        return formsDiagonalLineSouthWestSide || formsDiagonalLineNorthWestSide || formsDiagonalLineNorthEastSide || formsDiagonalLineSouthEastSide;
    }
}
