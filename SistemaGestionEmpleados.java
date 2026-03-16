import java.util.Scanner; 

/**
 * Aplicación principal de ejemplo que muestra el uso de la gestión de empleados.
 * <p>
 * Crea una colección de empleados, solicita un porcentaje de aumento por consola
 * y aplica el aumento a todos los empleados.
 */
public class SistemaGestionEmpleados {

    /**
     * Punto de entrada de la aplicación.
     *
     * @param args argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
    // Crear la colección de empleados con capacidad inicial 3
    Empleados empleados = new Empleados(Constantes.INITIAL_CAPACITY);

    // Dar de alta los tres empleados de ejemplo usando el nuevo método darAlta
    empleados.darAlta(new Empleado("Juan Pérez", Cargos.DESARROLLADOR, 50000));
    empleados.darAlta(new Empleado("María González", Cargos.DISEÑADORA, 45000));
    empleados.darAlta(new Empleado("Pedro López", Cargos.GERENTE, 60000));

    Scanner scanner = new Scanner(System.in);
    System.out.print(Constantes.MSG_INTRO_PORCENTAJE);
    double porcentaje = scanner.nextDouble();

    empleados.aumentarSalario(porcentaje);

    System.out.println(Constantes.MSG_LISTADO_EMPLEADOS);
    empleados.mostrarListado();

    scanner.close();
    }
}
