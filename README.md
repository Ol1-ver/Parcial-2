# Sistema de gestión de empleados — Repositorio

Resumen
--------
Este repositorio contiene una pequeña aplicación Java de ejemplo para la gestión de empleados. Incluye las clases del modelo, una clase de gestión de colecciones, una pequeña aplicación principal y tests unitarios para validar las reglas de negocio.

Metadatos
---------
- Autor: [TU NOMBRE]
- Versión: 1.0.0

Estructura del proyecto
-----------------------
- `Empleado.java` — clase que representa a un empleado (nombre, cargo, salario) y valida las entradas.
- `Empleados.java` — clase que administra un conjunto de empleados (alta, listado, aumento salarial).
- `Cargos.java` — lista centralizada de cargos permitidos (constantes).
- `Constantes.java` — mensajes y constantes utilizadas por la aplicación.
- `SistemaGestionEmpleados.java` — clase con el `main` de ejemplo que crea empleados y aplica un aumento.
- `TESTING.md` — análisis de caja negra con casos válidos y no válidos.
- `pom.xml` — configuración Maven para ejecutar los tests (JUnit 5).
- `src/test/java/EmpleadoTest.java` — pruebas JUnit 5 que implementan los casos del `TESTING.md`.

Descripción del código
----------------------
- `Empleado` encapsula la información de un trabajador. Realiza validaciones en constructor y setters:
  - `nombre`: no nulo, no vacío y debe tener al menos dos palabras.
  - `cargo`: debe estar en la lista definida en `Cargos`.
  - `salario`: no NaN, no infinito, no negativo y >= `Constantes.SALARIO_MINIMO`.
- `Empleados` mantiene un array dinámico de `Empleado` y proporciona `darAlta`, `aumentarSalario` y `mostrarListado`.
- `SistemaGestionEmpleados` es un ejemplo de uso que solicita por consola un porcentaje y aplica el aumento.

Cómo compilar y ejecutar (sin Maven)
-----------------------------------
En PowerShell, desde la raíz del proyecto:

```powershell
# Compilar todas las clases Java que están en la raíz
javac .\*.java

# Ejecutar la aplicación (ejemplo)
echo 10 | java -cp . SistemaGestionEmpleados
```

Cómo ejecutar tests (requiere Maven)
-----------------------------------
Si quieres ejecutar los tests JUnit 5 incluidos, instala Maven y desde la raíz ejecuta:

```powershell
mvn test
```

Nota: si `mvn` no está disponible, instala Maven o ejecútalo con la herramienta que prefieras. También es posible ejecutar los tests directamente usando los JARs de JUnit en el classpath, pero Maven automatiza la gestión de dependencias.

Testing y calidad
------------------
- `TESTING.md` contiene el análisis de caja negra y las tablas de prueba.
- `src/test/java/EmpleadoTest.java` implementa los casos válidos y no válidos (JUnit 5). Si quieres que ejecute los tests en este entorno, indícamelo y te guiaré en la instalación de Maven o usaré un runner alternativo.

Cambios y notas
----------------
- El código incluye JavaDoc básico en las clases principales para facilitar el mantenimiento.
- Si deseas que ajuste las reglas (por ejemplo, permitir nombres de una sola palabra) lo puedo modificar de forma puntual.
