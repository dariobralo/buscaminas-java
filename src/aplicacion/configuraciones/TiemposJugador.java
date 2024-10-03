package configuraciones;

public class TiemposJugador {

    private static int recordFacil = Integer.MAX_VALUE;
    private static int recordIntermedio = Integer.MAX_VALUE;
    private static int recordDificil = Integer.MAX_VALUE;

    public TiemposJugador() {}

    public static boolean nuevoRecord(int dificultad, int nuevoTiempo) {
        if (dificultad== NivelesConst.getMINAS_FACIL()) {
            if (recordFacil>nuevoTiempo) {
                recordFacil = nuevoTiempo;
                return true;
            }
        } else if (dificultad==NivelesConst.getMINAS_MEDIO()) {
            if (recordIntermedio>nuevoTiempo) {
                recordIntermedio = nuevoTiempo;
                return true;
            }
        } else if (dificultad==NivelesConst.getMINAS_DIFICIL()) {
            if (recordDificil>nuevoTiempo) {
                recordDificil = nuevoTiempo;
                return true;
            }
        }
        return false;
    }


    public String toString() {
        return "Tabla de mejores tiempos "  + " segundos";
    }

    public static long getRecordFacil() {
        return recordFacil == Integer.MAX_VALUE ?  0 : recordFacil;
    }

    public static long getRecordIntermedio() {
        return recordIntermedio == Integer.MAX_VALUE ? 0 : recordIntermedio;
    }

    public static long getRecordDificil() {
        return recordDificil == Integer.MAX_VALUE ? 0 : recordDificil;
    }

}
