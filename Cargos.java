public class Cargos {
    public static final String DESARROLLADOR = "Desarrollador";
    public static final String DISEÑADORA = "Diseñadora";
    public static final String GERENTE = "Gerente";

    private static final String[] LISTA = {
            DESARROLLADOR,
            DISEÑADORA,
            GERENTE
    };

    public static String[] getLista() {
        return LISTA.clone();
    }

    public static boolean esValido(String cargo) {
        if (cargo == null) return false;
        for (String c : LISTA) {
            if (c.equals(cargo)) return true;
        }
        return false;
    }
}
