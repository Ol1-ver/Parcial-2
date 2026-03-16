/**
 * Representa un empleado de la empresa.
 * <p>
 * La clase mantiene tres atributos principales: nombre, cargo y salario.
 * Se validan entradas en el constructor y en los setters para garantizar
 * que los objetos estén en un estado válido.
 */
class Empleado {
    /** Nombre completo del empleado. Debe contener al menos dos palabras. */
    private String nombre;
    /** Cargo profesional del empleado; debe pertenecer a la lista definida en {@link Cargos}. */
    private String cargo;
    /** Salario del empleado (unidad monetaria consistente con la aplicación). */
    private double salario;

    /**
     * Construye un nuevo {@code Empleado} validando los parámetros.
     *
     * @param nombre nombre completo (no nulo, no vacío, al menos dos palabras)
     * @param cargo  cargo profesional (no nulo y debe ser válido según {@link Cargos})
     * @param salario salario (no NaN, no infinito, >= 0 y >= {@link Constantes#SALARIO_MINIMO})
     * @throws IllegalArgumentException si algún parámetro no cumple las restricciones
     */
    public Empleado(String nombre, String cargo, double salario) {
        setNombre(nombre);
        setCargo(cargo);
        setSalario(salario);
    }

    /**
     * Obtiene el nombre completo del empleado.
     *
     * @return el nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre nombre completo (no nulo, no vacío, al menos dos palabras)
     * @throws IllegalArgumentException si el nombre es nulo, vacío o no contiene al menos dos palabras
     */
    public void setNombre(String nombre) {
        if (nombre == null) throw new IllegalArgumentException("Nombre no puede ser nulo");
        String trimmed = nombre.trim();
        if (trimmed.isEmpty()) throw new IllegalArgumentException("Nombre no puede estar vacío");
        // comprobar al menos dos palabras (tokens separados por espacios)
        String[] tokens = trimmed.split("\\s+");
        if (tokens.length < 2) throw new IllegalArgumentException("Nombre debe contener al menos dos palabras");
        this.nombre = trimmed;
    }

    /**
     * Obtiene el cargo profesional del empleado.
     *
     * @return el cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el cargo del empleado.
     *
     * @param cargo cargo profesional (no nulo y debe estar en {@link Cargos})
     * @throws IllegalArgumentException si el cargo es nulo o no válido
     */
    public void setCargo(String cargo) {
        if (cargo == null) throw new IllegalArgumentException("Cargo no puede ser nulo");
        if (!Cargos.esValido(cargo)) throw new IllegalArgumentException(Constantes.MSG_CARGO_NO_PERMITIDO + cargo);
        this.cargo = cargo;
    }

    /**
     * Obtiene el salario del empleado.
     *
     * @return el salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario del empleado.
     *
     * @param salario salario a asignar (no NaN, no infinito, >= 0 y >= {@link Constantes#SALARIO_MINIMO})
     * @throws IllegalArgumentException si el salario no cumple las restricciones
     */
    public void setSalario(double salario) {
        if (Double.isNaN(salario) || Double.isInfinite(salario)) throw new IllegalArgumentException("Salario no es un número válido");
        if (salario < 0) throw new IllegalArgumentException("Salario no puede ser negativo");
        if (salario < Constantes.SALARIO_MINIMO) throw new IllegalArgumentException("Salario por debajo del convenio: " + salario);
        this.salario = salario;
    }

    /**
     * Representación en cadena del empleado.
     *
     * @return string con nombre, cargo y salario
     */
    @Override
    public String toString() {
        return String.format(Constantes.FMT_EMPLEADO, nombre, cargo, salario);
    }
}
