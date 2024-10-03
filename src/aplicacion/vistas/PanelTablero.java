package vistas;

import componentes.CalculadorMemoria;
import componentes.Casilla;
import controladores.Controlador;
import configuraciones.TiemposJugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelTablero extends JPanel {

    private final int FILAS_TABLERO;
    private final int COLUMNAS_TABLERO;
    private final int MINAS_CANTIDAD;
    private final int META;
    private int contador;
    private Casilla[][] casillas;
    private Controlador controlador;
    private Timer timer;
    private int segundos;
    private JLabel labelTimer;
    private JPanel tableroPanel;


    public PanelTablero(int filas, int columnas, int minas) {
        this.FILAS_TABLERO = filas;
        this.COLUMNAS_TABLERO = columnas;
        this.MINAS_CANTIDAD = minas;
        this.META = FILAS_TABLERO*COLUMNAS_TABLERO - MINAS_CANTIDAD;
        this.contador = 0;
        initComponents(filas, columnas);
        inicializarCasillas();
        generarMinas();
        iniciarCronometro();

        //Funciones para ver el tablero generado por consola y el uso de memoria.
        //Activar las lines de codigo para ver.

//        CalculadorMemoria.imprimirUsoMemoria("Tablero creado");
//        imprimirTablero();
    }

    private void initComponents(int filas, int columnas){
        setLayout(new BorderLayout());

        labelTimer = new JLabel("", SwingConstants.CENTER);
        labelTimer.setFont(new Font("Arial", Font.BOLD, 16));
        labelTimer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(labelTimer, BorderLayout.NORTH);

        tableroPanel = new JPanel(new GridLayout(filas, columnas));
        add(tableroPanel, BorderLayout.CENTER);
    }

    public void inicializarCasillas(){
        casillas = new Casilla[this.FILAS_TABLERO][this.COLUMNAS_TABLERO];
        for (int i = 0; i < casillas.length; i++){
            for (int j = 0; j < casillas[i].length; j++){
                Casilla nuevaCasilla = new Casilla(i, j);
                casillas [i][j] = nuevaCasilla;
                nuevaCasilla.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)){
                            if (nuevaCasilla.isCasillaRevelada()) validarCasillasMarcadas(nuevaCasilla.getFila(), nuevaCasilla.getColumna());
                            if (!nuevaCasilla.isCasillaRevelada()) validarCasilla(nuevaCasilla.getFila(), nuevaCasilla.getColumna());
                        } else if (SwingUtilities.isRightMouseButton(e)) {
                            if (!nuevaCasilla.isCasillaRevelada()) marcarCasilla(nuevaCasilla.getFila(), nuevaCasilla.getColumna());
                        }
                    }
                });
                tableroPanel.add(casillas[i][j]);
            }
        }
    }

    private void generarMinas(){
        int minasGeneradas = 0;
        while ( minasGeneradas != MINAS_CANTIDAD){
            int posTmpFila = (int) (Math.random()* casillas.length);
            int posTmpColumna = (int) (Math.random()*casillas[0].length);
            if (!casillas[posTmpFila][posTmpColumna].isMina()){
                casillas[posTmpFila][posTmpColumna].setMina(true);
                minasGeneradas++;
                this.actualizarPistas(posTmpFila, posTmpColumna);
            }
        }
    }

    private void actualizarPistas(int fila, int columna){
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int filaVecina = fila + i;
                int columnaVecina = columna + j;

                if (filaVecina >= 0 && filaVecina < FILAS_TABLERO
                    && columnaVecina >= 0 && columnaVecina < COLUMNAS_TABLERO) {
                    casillas[filaVecina][columnaVecina].setNumPista(casillas[filaVecina][columnaVecina].getNumPista()+1);
                }

            }
        }
    }

    // Control tiempo
    private void iniciarCronometro(){
        segundos = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                labelTimer.setText("Tiempo: " + segundos + " s");
            }
        });
        timer.start();
    }

    private void detenerCronometro(){
        if (timer != null){
            timer.stop();
        }
    }

    /*
     * Accion de botón derecho
     */
    private void marcarCasilla(int filaSeleccionada, int columnaSeleccionada){
        if (!casillas[filaSeleccionada][columnaSeleccionada].isCasillaMarcada()) {
            casillas[filaSeleccionada][columnaSeleccionada].setBackground(Color.yellow);
            casillas[filaSeleccionada][columnaSeleccionada].setCasillaMarcada(true);
        } else {
            casillas[filaSeleccionada][columnaSeleccionada].setBackground(Color.gray);
            casillas[filaSeleccionada][columnaSeleccionada].setCasillaMarcada(false);
        }
    }

    private void validarCasillasMarcadas(int filaSeleccionada, int columnaSeleccionada){
        int casillaMarcada = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int filaVecina = filaSeleccionada + i;
                int columnaVecina = columnaSeleccionada + j;
                if (filaVecina >= 0 && filaVecina < FILAS_TABLERO && columnaVecina >= 0 && columnaVecina < COLUMNAS_TABLERO) {
                    if(casillas[filaVecina][columnaVecina].isCasillaMarcada()) {
                        casillaMarcada ++;
                    }
                }
            }
        }
        if (casillaMarcada == casillas[filaSeleccionada][columnaSeleccionada].getNumPista()) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int filaVecina = filaSeleccionada + i;
                    int columnaVecina = columnaSeleccionada + j;
                    if (filaVecina >= 0 && filaVecina < FILAS_TABLERO && columnaVecina >= 0 && columnaVecina < COLUMNAS_TABLERO) {
                        if(!casillas[filaVecina][columnaVecina].isCasillaMarcada()) {
                            validarCasilla(filaVecina, columnaVecina);
                        }
                    }
                }
            }
        }
    }

    /*
     * Acciones al cliclear casilla no revelada
     */
    private void validarCasilla(int filaSeleccionada, int columnaSeleccionada){
        if (casillas[filaSeleccionada][columnaSeleccionada].isMina()){
            this.partidaPerdida();
        } else {
            this.confirmarCasillaSegura(filaSeleccionada, columnaSeleccionada);
        }
    }

    /* Al validar que la casilla no tenga una mina, el siguiente metodo se encarga de verificar si
     * la casilla ya fue revelada, actualizar el contador para controlar el avance en la partida y
     * en caso que la casilla no tengo minas alrededor (numPista = 0), ejecutar el revelado de las
     * casillas vecinas, aplicandose de manera recursiva en caso de repetirse esta situacion.
     */
    private void confirmarCasillaSegura(int filaSeleccionada, int columnaSeleccionada){
        if (casillas[filaSeleccionada][columnaSeleccionada].isCasillaRevelada()) return;
        casillas[filaSeleccionada][columnaSeleccionada].setCasillaRevelada(true);
        casillas[filaSeleccionada][columnaSeleccionada].setBackground(Color.white);
        casillas[filaSeleccionada][columnaSeleccionada].setText(String.valueOf(casillas[filaSeleccionada][columnaSeleccionada].getNumPista()));
        contador++;
        if (contador == META) partidaGanada();
        if (casillas[filaSeleccionada][columnaSeleccionada].getNumPista() > 0) return;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int filaVecina = filaSeleccionada + i;
                int columnaVecina = columnaSeleccionada + j;
                if (filaVecina >= 0 && filaVecina < FILAS_TABLERO && columnaVecina >= 0 && columnaVecina < COLUMNAS_TABLERO) {
                    this.confirmarCasillaSegura(filaVecina, columnaVecina);
                }
            }
        }
    }

    private void partidaGanada(){
        for (int i = 0; i < FILAS_TABLERO; i++) {
            for (int j = 0; j < COLUMNAS_TABLERO; j++) {
                casillas[i][j].setEnabled(false);
                if (casillas[i][j].isMina()){
                    casillas[i][j].setText("X");
                    casillas[i][j].setBackground(Color.red);
                }
            }
        }
        detenerCronometro();
        if (TiemposJugador.nuevoRecord(MINAS_CANTIDAD, segundos)) {
            JOptionPane.showMessageDialog(null, "Partida Ganada!\n¡Nuevo Record! Tiempo: "
                    + segundos + " segundos!\n");
            controlador.partidaFinalizada();
        } else {
            JOptionPane.showMessageDialog(null, "Partida Ganada!\nTiempo: " + segundos + " segundos\n");
            controlador.partidaFinalizada();
        }
    }

    private void partidaPerdida(){
        for (int i = 0; i < FILAS_TABLERO; i++) {
            for (int j = 0; j < COLUMNAS_TABLERO; j++) {
                casillas[i][j].setEnabled(false);
                if (casillas[i][j].isMina()){
                    casillas[i][j].setText("X");
                    casillas[i][j].setBackground(Color.red);
                }
            }
        }
        detenerCronometro();
        JOptionPane.showMessageDialog(null, "Has perdido!");
        controlador.partidaFinalizada();
    }


    //Impresión de tablero en consola
    private void imprimirTablero() {
        for (int i = 0; i < casillas.length; i++){
            for (int j = 0; j < casillas[i].length; j++){
                System.out.print(casillas[i][j].isMina()?"* ":casillas[i][j].getNumPista()+" ");
            }
            System.out.println("");
        }
    }


    //Getters and Setters
    public int getFILAS_TABLERO() {
        return FILAS_TABLERO;
    }

    public int getCOLUMNAS_TABLERO() {
        return COLUMNAS_TABLERO;
    }

    public int getMINAS_CANTIDAD() {
        return MINAS_CANTIDAD;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}
