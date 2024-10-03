package configuraciones;

public class NivelesConst {

    // Densidad de minas de ~9.4%
    public static final int FILAS_FACIL = 8;
    public static final int COLUMNAS_FACIL = 8;
    public static final int MINAS_FACIL = 7;

    // Densidad de minas de ~12%
    public static final int FILAS_MEDIO = 11;
    public static final int COLUMNAS_MEDIO = 11;
    public static final int MINAS_MEDIO = 15;

    // Densidad de minas de 20%
    public static final int FILAS_DIFICIL = 15;
    public static final int COLUMNAS_DIFICIL = 20;
    public static final int MINAS_DIFICIL = 60;


    private NivelesConst(){}


    public static int getFILAS_FACIL() {
        return FILAS_FACIL;
    }

    public static int getCOLUMNAS_FACIL() {
        return COLUMNAS_FACIL;
    }

    public static int getMINAS_FACIL() {
        return MINAS_FACIL;
    }

    public static int getFILAS_MEDIO() {
        return FILAS_MEDIO;
    }

    public static int getCOLUMNAS_MEDIO() {
        return COLUMNAS_MEDIO;
    }

    public static int getMINAS_MEDIO() {
        return MINAS_MEDIO;
    }

    public static int getFILAS_DIFICIL() {
        return FILAS_DIFICIL;
    }

    public static int getCOLUMNAS_DIFICIL() {
        return COLUMNAS_DIFICIL;
    }

    public static int getMINAS_DIFICIL() {
        return MINAS_DIFICIL;
    }
}
