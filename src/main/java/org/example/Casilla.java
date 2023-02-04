package org.example;

public class Casilla {
    public boolean ocupado;

    public Casilla() {
        ocupado = false;
    }

    public void ocupar() {
        ocupado = true;
    }

    public void desocupar() {
        ocupado = false;
    }
}
