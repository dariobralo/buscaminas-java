package componentes;

import javax.swing.*;
import java.awt.*;

public class Casilla extends JButton {

    private int fila;
    private int columna;
    private boolean mina = false;
    private int numPista = 0;
    private boolean casillaRevelada = false;
    private boolean casillaMarcada = false;


    /*
     * Constructors
     */
    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        setMargin(new Insets(0, 0, 0, 0));
        setFocusPainted(false);
        setFont(new Font("Arial", Font.BOLD, 12));
        setSize(15, 15);
        setBackground(Color.gray);
    }


    /*
     * Getters and Setters
     */
    public int getNumPista() {
        return numPista;
    }

    public void setNumPista(int numPista) {
        this.numPista = numPista;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isCasillaRevelada() {
        return casillaRevelada;
    }

    public void setCasillaRevelada(boolean casillaRevelada) {
        this.casillaRevelada = casillaRevelada;
    }

    public boolean isCasillaMarcada() {
        return casillaMarcada;
    }

    public void setCasillaMarcada(boolean casillaMarcada) {
        this.casillaMarcada = casillaMarcada;
    }
}
