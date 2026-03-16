# TESTING — Análisis de Caja Negra para la clase Empleado

Resumen breve
- Objetivo: definir criterios de aceptación y casos de prueba (válidos y no válidos) para los tres atributos de `Empleado`: `nombre`, `cargo` y `salario`.
- Suposiciones:
  - Unidad y escala de `salario`: misma que en el código existente (valores ejemplo: 45000, 50000...).
  - Convenio salarial (salario mínimo aceptable): 15000 (unidad consistente con los ejemplos). Esta cifra es una asunción razonable; si tienes otra cifra oficial, la actualizo.
  - Para `nombre`, "más de una palabra" se interpreta como al menos dos tokens separados por espacio(s).

## Criterios de aceptación (resumen)
- Nombre: no vacío, al menos dos palabras (p.ej. "Juan Pérez").
- Cargo: debe pertenecer a la lista definida en `Cargos` (por ejemplo: "Desarrollador", "Diseñadora", "Gerente").
- Salario: debe proporcionarse (no nulo), ser numérico, >= 0 y >= convenio salarial (15000).

---

## 1) Tabla: Análisis de parámetros

| Parámetro | Tipo esperado | Restricciones / Dominio | Observaciones |
|---|---:|---|---|
| nombre | String | No vacío; al menos 2 palabras; longitud razonable (>=3 caracteres total) | Evitar nombres con sólo espacios. Se considera válido si contiene al menos un espacio entre tokens.
| cargo | String (enum-like) | Debe ser uno de los valores de `Cargos` (p.ej. Desarrollador, Diseñadora, Gerente) | Lista centralizada en `Cargos`. Rechazar cualquier string distinto exacto.
| salario | double / numeric | No nulo; >= 0; >= CONVENIO_SALARIAL (15000) | Valores decimales aceptables; no aceptar NaN o Infinity.

---

## 2) Tabla: Casos válidos (happy path)

| ID | Nombre | Cargo | Salario | Resultado esperado |
|---:|---|---|---:|---|
| V1 | "Juan Pérez" | "Desarrollador" | 50000 | Aceptado; empleado creado correctamente |
| V2 | "María González" | "Diseñadora" | 45000 | Aceptado |
| V3 | "Ana López" | "Gerente" | 15000 | Aceptado (igual al mínimo del convenio) |
| V4 | "Carlos Martínez" | "Desarrollador" | 15000.50 | Aceptado (decimal > convenio) |
| V5 | "José Luis" | "Gerente" | 20000 | Aceptado (nombre con espacio y dos tokens) |

Notas: estos casos usan cargos exactamente igual a los constantes en `Cargos`. Los nombres incluyen al menos dos palabras.

---

## 3) Tabla: Casos no válidos (negativos / boundary / formato)

| ID | Nombre | Cargo | Salario | Tipo de fallo | Resultado esperado |
|---:|---|---|---:|---|---|
| N1 | "" (vacío) | "Desarrollador" | 50000 | Nombre vacío | Rechazado (error: nombre inválido) |
| N2 | "Juan" (una sola palabra) | "Desarrollador" | 50000 | Nombre con una palabra | Rechazado (error: nombre inválido) |
| N3 | "  " (solo espacios) | "Desarrollador" | 50000 | Nombre sólo espacios | Rechazado |
| N4 | "Juan Pérez" | "Programador" | 50000 | Cargo no existente | Rechazado (error: cargo no permitido) |
| N5 | "María García" | "desarrollador" (minúsculas) | 50000 | Cargo con distinto case | Rechazado (comparación exacta) |
| N6 | "Ana Ruiz" | "Gerente" | 14000 | Salario por debajo del convenio | Rechazado (error: salario < convenio) |
| N7 | "Pedro Díaz" | "Gerente" | -1000 | Salario negativo | Rechazado (error: salario negativo) |
| N8 | "Luisa Fernández" | "Diseñadora" | 0 | Salario = 0 (si convenio > 0) | Rechazado si convenio>0; con convenio=15000 es rechazado |
| N9 | null | "Desarrollador" | 50000 | Nombre nulo | Rechazado (error de entrada) |
| N10 | "María José" | null | 50000 | Cargo nulo | Rechazado (cargo no permitido) |
| N11 | "María José" | "Diseñadora" | NaN | Salario no numérico | Rechazado (input inválido) |

Notas sobre casos límite y comportamiento esperado
- Comparación de `cargo` debe ser exacta (case-sensitive) según `Cargos.esValido`. Si se desea tolerancia a mayúsculas/minúsculas, definir y documentar.
- En producción, los rechazos deben reportarse con excepciones claras (p.ej. IllegalArgumentException) o mensajes de validación en la capa que recibe entrada.
- Si quieres, puedo añadir pruebas unitarias automatizadas (JUnit) que implementen estos casos.

---

## Conclusión y next steps recomendados
- Confirmar el valor real del convenio salarial si 15000 no es correcto; ajustar las tablas en consecuencia.
- Decidir la política de comparación de `cargo` (sensible a mayúsculas o no).
- Implementar validaciones en la clase `Empleado` o en la capa de creación (p.ej. en `Empleados.darAlta`) según los criterios arriba definidos y añadir tests automáticos.
