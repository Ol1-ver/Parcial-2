import java.util.Arrays;

/**
 * Gestión agregada de múltiples empleados.
 * <p>
 * Esta clase encapsula un array dinámico sencillo de {@link Empleado} y
 * ofrece operaciones básicas: dar de alta, aumentar salarios y mostrar listado.
 */
public class Empleados {
    /**
     * Array que contiene los empleados. Se expande automáticamente si se llena.
     */
    private Empleado[] lista;
    /** Número de empleados actualmente almacenados en {@link #lista} */
    private int count;

    /**
     * Construye una colección de empleados con la capacidad inicial indicada.
     *
     * @param capacidad capacidad inicial del array
     */
    public Empleados(int capacidad) {
        this.lista = new Empleado[capacidad];
        this.count = 0;
    }

    /**
     * Añade (da de alta) un nuevo empleado a la colección.
     *
     * @param empleado el empleado a añadir (su cargo será validado contra {@link Cargos})
     * @throws IllegalArgumentException si el cargo no está permitido
     */
    public void darAlta(Empleado empleado) {
        // validar que el cargo del empleado esté en la lista de cargos permitidos
        if (!Cargos.esValido(empleado.getCargo())) {
            throw new IllegalArgumentException(Constantes.MSG_CARGO_NO_PERMITIDO + empleado.getCargo());
        }

        if (count < lista.length) {
            lista[count++] = empleado;
        } else {
            // si se alcanza la capacidad, ampliar el array (comportamiento sencillo)
            int nuevaCap = lista.length * 2;
            if (nuevaCap == 0) nuevaCap = 1;
            lista = Arrays.copyOf(lista, nuevaCap);
            lista[count++] = empleado;
        }
    }

    /**
     * Aumenta el salario de todos los empleados en el porcentaje indicado.
     *
     * @param porcentaje porcentaje de aumento (por ejemplo 10 para 10%)
     */
    public void aumentarSalario(double porcentaje) {
        for (int i = 0; i < count; i++) {
            Empleado empleado = lista[i];
            double nuevoSalario = empleado.getSalario() * (1 + porcentaje / 100);
            empleado.setSalario(nuevoSalario);
        }
    }

    /**
     * Muestra por consola el listado de empleados actualmente dados de alta.
     */
    public void mostrarListado() {
        for (int i = 0; i < count; i++) {
            System.out.println(lista[i]);
        }
    }

    /**
     * Devuelve el array interno (nota: puede contener posiciones nulas si no está lleno).
     *
     * @return el array interno de empleados
     */
    public Empleado[] getLista() {
        return lista;
    }
}
