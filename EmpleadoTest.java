import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    // Casos válidos
    @Test
    public void crearEmpleadoValido_V1() {
        Empleado e = new Empleado("Juan Pérez", Cargos.DESARROLLADOR, 50000);
        assertEquals("Juan Pérez", e.getNombre());
        assertEquals(Cargos.DESARROLLADOR, e.getCargo());
        assertEquals(50000, e.getSalario());
    }

    @Test
    public void crearEmpleadoValido_V2() {
        Empleado e = new Empleado("María González", Cargos.DISEÑADORA, 45000);
        assertEquals("María González", e.getNombre());
        assertEquals(Cargos.DISEÑADORA, e.getCargo());
    }

    @Test
    public void crearEmpleadoValido_V3_Minimo() {
        Empleado e = new Empleado("Ana López", Cargos.GERENTE, Constantes.SALARIO_MINIMO);
        assertEquals(Constantes.SALARIO_MINIMO, e.getSalario());
    }

    // Casos no válidos (nombre)
    @Test
    public void nombreVacio_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("", Cargos.DESARROLLADOR, 50000));
    }

    @Test
    public void nombreUnaPalabra_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Juan", Cargos.DESARROLLADOR, 50000));
    }

    @Test
    public void nombreSoloEspacios_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("   ", Cargos.DESARROLLADOR, 50000));
    }

    @Test
    public void nombreNulo_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado(null, Cargos.DESARROLLADOR, 50000));
    }

    // Casos no válidos (cargo)
    @Test
    public void cargoNoExistente_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Juan Pérez", "Programador", 50000));
    }

    @Test
    public void cargoCaseDifferent_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("María García", "desarrollador", 50000));
    }

    @Test
    public void cargoNulo_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("María José", null, 50000));
    }

    // Casos no válidos (salario)
    @Test
    public void salarioPorDebajoConvenio_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Ana Ruiz", Cargos.GERENTE, 14000));
    }

    @Test
    public void salarioNegativo_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Pedro Díaz", Cargos.GERENTE, -1000));
    }

    @Test
    public void salarioCero_debeFallarSiConvenioMayor() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Luisa Fernández", Cargos.DISEÑADORA, 0));
    }

    @Test
    public void salarioNaN_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("María José", Cargos.DISEÑADORA, Double.NaN));
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    // Casos válidos
    @Test
    public void crearEmpleadoValido_V1() {
        Empleado e = new Empleado("Juan Pérez", Cargos.DESARROLLADOR, 50000);
        assertEquals("Juan Pérez", e.getNombre());
        assertEquals(Cargos.DESARROLLADOR, e.getCargo());
        assertEquals(50000, e.getSalario());
    }

    @Test
    public void crearEmpleadoValido_V2() {
        Empleado e = new Empleado("María González", Cargos.DISEÑADORA, 45000);
        assertEquals("María González", e.getNombre());
        assertEquals(Cargos.DISEÑADORA, e.getCargo());
    }

    @Test
    public void crearEmpleadoValido_V3_Minimo() {
        Empleado e = new Empleado("Ana López", Cargos.GERENTE, Constantes.SALARIO_MINIMO);
        assertEquals(Constantes.SALARIO_MINIMO, e.getSalario());
    }

    // Casos no válidos (nombre)
    @Test
    public void nombreVacio_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("", Cargos.DESARROLLADOR, 50000));
    }

    @Test
    public void nombreUnaPalabra_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Juan", Cargos.DESARROLLADOR, 50000));
    }

    @Test
    public void nombreSoloEspacios_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("   ", Cargos.DESARROLLADOR, 50000));
    }

    @Test
    public void nombreNulo_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado(null, Cargos.DESARROLLADOR, 50000));
    }

    // Casos no válidos (cargo)
    @Test
    public void cargoNoExistente_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Juan Pérez", "Programador", 50000));
    }

    @Test
    public void cargoCaseDifferent_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("María García", "desarrollador", 50000));
    }

    @Test
    public void cargoNulo_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("María José", null, 50000));
    }

    // Casos no válidos (salario)
    @Test
    public void salarioPorDebajoConvenio_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Ana Ruiz", Cargos.GERENTE, 14000));
    }

    @Test
    public void salarioNegativo_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Pedro Díaz", Cargos.GERENTE, -1000));
    }

    @Test
    public void salarioCero_debeFallarSiConvenioMayor() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("Luisa Fernández", Cargos.DISEÑADORA, 0));
    }

    @Test
    public void salarioNaN_debeFallar() {
        assertThrows(IllegalArgumentException.class, () -> new Empleado("María José", Cargos.DISEÑADORA, Double.NaN));
    }
}
