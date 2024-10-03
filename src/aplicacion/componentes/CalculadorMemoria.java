package componentes;

public class CalculadorMemoria {

    public static Runtime runtime;
    public static long memoriaTotal;
    public static long memoriaLibre;
    public static long memoriaEnUso;
    public String texto;

    public CalculadorMemoria(){
        runtime = Runtime.getRuntime();
        memoriaTotal = runtime.totalMemory();
        memoriaLibre = runtime.freeMemory();
        memoriaEnUso = memoriaTotal - memoriaLibre;
    }

    public static void imprimirUsoMemoria(String texto){
        runtime = Runtime.getRuntime();
        memoriaTotal = runtime.totalMemory();
        memoriaLibre = runtime.freeMemory();
        memoriaEnUso = memoriaTotal - memoriaLibre;
        System.out.println( "*******************************************\n"
                + texto + "\nMemoria Total: " + memoriaTotal/1024
                + "Kb.\nMemoria Libre: " + memoriaLibre/1024
                + "Kb.\nMemoria en Uso: " + memoriaEnUso/1024 + "Kb.\n"
                + "*******************************************\n");
    }

}
