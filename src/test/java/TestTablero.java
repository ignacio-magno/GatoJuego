import org.example.Tablero;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTablero {

    @Test
    public void NewTablero() {
        Tablero tablero = new Tablero(8, 8);
        assertEquals(8, tablero.casillas.length);
        assertEquals(8, tablero.casillas[0].length);
    }

    @Test
    public void FillTablero() {
        Tablero tablero = new Tablero(8, 8);

        tablero.SetCasillaOcupada(2, 1);

        assertTrue(tablero.casillas[1][2].ocupado);
    }

    @Test
    public void CheckHorizontal1() {
        Tablero tablero = new Tablero(8, 8);

        tablero.SetCasillaOcupada(1, 0);
        tablero.SetCasillaOcupada(2, 0);
        tablero.SetCasillaOcupada(3, 0);

        assertTrue(tablero.ExistWinner());
    }


    @Test
    public void CheckHorizontal2() {
        Tablero tablero = new Tablero(8, 8);

        tablero.SetCasillaOcupada(5, 4);
        tablero.SetCasillaOcupada(4, 4);
        tablero.SetCasillaOcupada(3, 4);

        assertTrue(tablero.ExistWinner());
    }

    @Test
    public void CheckHorizontal3() {
        Tablero tablero = new Tablero(8, 8);

        tablero.SetCasillaOcupada(0, 7);
        tablero.SetCasillaOcupada(1, 7);
        tablero.SetCasillaOcupada(2, 7);

        assertTrue(tablero.ExistWinner());
    }

    @Test
    public void CheckVertical1() {
        Tablero tablero = new Tablero(8, 8);

        tablero.SetCasillaOcupada(0, 1);
        tablero.SetCasillaOcupada(0, 2);
        tablero.SetCasillaOcupada(0, 3);

        assertTrue(tablero.ExistWinner());
    }


    @Test
    public void CheckVertical2() {
        Tablero tablero = new Tablero(8, 8);

        tablero.SetCasillaOcupada(4, 5);
        tablero.SetCasillaOcupada(4, 7);
        tablero.SetCasillaOcupada(4, 6);

        assertTrue(tablero.ExistWinner());
    }

    @Test
    public void CheckDiagonal1() {
        Tablero tablero = new Tablero(8, 8);

        tablero.SetCasillaOcupada(1, 1);
        tablero.SetCasillaOcupada(2, 2);
        tablero.SetCasillaOcupada(3, 3);

        assertTrue(tablero.ExistWinner());
    }

    @Test
    public void CheckDiagonal2() {
        Tablero tablero = new Tablero(8, 8);

        tablero.SetCasillaOcupada(3, 1);
        tablero.SetCasillaOcupada(4, 2);
        tablero.SetCasillaOcupada(5, 3);

        assertTrue(tablero.ExistWinner());
    }

    @Test
    public void CheckDiagonalInversa() {
        Tablero tablero = new Tablero(8, 8);

        tablero.SetCasillaOcupada(3, 1);
        tablero.SetCasillaOcupada(2, 2);
        tablero.SetCasillaOcupada(1, 3);

        assertTrue(tablero.ExistWinner());
    }

    @Test
    public void CheckDiagonalInversa2() {
        Tablero tablero = new Tablero(8, 8);

        tablero.SetCasillaOcupada(7, 5);
        tablero.SetCasillaOcupada(6, 6);
        tablero.SetCasillaOcupada(5, 7);

        assertTrue(tablero.ExistWinner());
    }
}
