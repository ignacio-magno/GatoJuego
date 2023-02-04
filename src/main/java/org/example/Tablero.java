package org.example;

public class Tablero {
    public Casilla[][] casillas;
    int CantidadCoincidanciasNecesariasParaGanar = 3;

    public Tablero(int rows, int cols) {
        casillas = new Casilla[rows][cols];
        for (int i = 0; i < rows; i++) {
            casillas[i] = new Casilla[cols];
            for (int j = 0; j < cols; j++) {
                casillas[i][j] = new Casilla();
            }
        }
    }

    public void SetCasillaOcupada(int x, int y) {
        casillas[y][x].ocupar();
    }

    public boolean ExistWinner() {
        int x = 0;
        int y = 0;

        while (y < casillas.length) {
            while (x < casillas[y].length) {
                if (casillas[y][x].ocupado) {
                    if (CheckHorizontal(x, y) || CheckVertical(x, y) || CheckDiagonal(x, y) || CheckDiagonalInversa(x, y)) {
                        return true;
                    }
                }
                x++;
            }
            y++;
            x = 0;
        }
        return false;
    }

    private boolean CheckDiagonal(int xInit, int yInit) {
        int coincidence = 0;
        int steps = 0;
        int currentX = xInit;
        int currentY = yInit;
        while (currentY < casillas.length && currentX < casillas[currentY].length && steps < CantidadCoincidanciasNecesariasParaGanar) {
            if (casillas[currentY][currentX].ocupado) {
                coincidence++;
            }
            steps++;
            currentX = xInit + steps;
            currentY = yInit + steps;
        }

        return coincidence == CantidadCoincidanciasNecesariasParaGanar;
    }

    private boolean CheckDiagonalInversa(int xInit, int yInit) {
        int coincidence = 0;
        int steps = 0;
        int currentX = xInit;
        int currentY = yInit;
        while (currentY < casillas.length && currentX < casillas[currentY].length && currentX >= 0 && steps < CantidadCoincidanciasNecesariasParaGanar) {
            if (casillas[currentY][currentX].ocupado) {
                coincidence++;
            }
            steps++;
            currentX = xInit - steps;
            currentY = yInit + steps;
        }

        return coincidence == CantidadCoincidanciasNecesariasParaGanar;
    }

    private boolean CheckHorizontal(int xInit, int yInit) {
        int coincidence = 0;
        // Check horizontal
        int steps = 0;
        int currentX = xInit + steps;
        // horizontal
        while (currentX < casillas[yInit].length && steps < CantidadCoincidanciasNecesariasParaGanar) {
            if (casillas[yInit][currentX].ocupado) {
                coincidence++;
            }
            steps++;
            currentX = xInit + steps;
        }
        return coincidence == CantidadCoincidanciasNecesariasParaGanar;
    }

    private boolean CheckVertical(int xInit, int yInit) {
        int coincidence = 0;
        // Check vertical
        int steps = 0;
        int currentY = yInit + steps;
        // vertical
        while (currentY < casillas.length && steps < CantidadCoincidanciasNecesariasParaGanar) {
            if (casillas[currentY][xInit].ocupado) {
                coincidence++;
            }
            steps++;
            currentY = yInit + steps;
        }

        return coincidence == CantidadCoincidanciasNecesariasParaGanar;
    }
}
