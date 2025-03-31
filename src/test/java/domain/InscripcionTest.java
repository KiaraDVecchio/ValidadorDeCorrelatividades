package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.HashSet;
import java.util.Set;

class InscripcionTest {

    private Alumno alumno;
    private Materia ddsi;
    private Materia pdp;
    private Materia aed;

    @BeforeEach
    void setUp() {
        alumno = new Alumno("Kiara", "Vecchio");

        ddsi = new Materia("Diseño de Sistemas de Información");
        pdp = new Materia("Paradigmas de la Programación");
        aed = new Materia("Algoritmos y Estructuras de Datos");

        ddsi.getCorrelativas().add(pdp);
        pdp.getCorrelativas().add(aed);
    }

    @Test
    @DisplayName("La inscripcion se aprueba si se cumplen las correlativas")
    public void inscripcionEsAprobada() {

        alumno.agregarMateriasAprobadas(pdp);
        alumno.agregarMateriasAprobadas(aed);

        Set<Materia> materiasACursar = new HashSet<>();
        materiasACursar.add(ddsi);

        Inscripcion inscripcion = new Inscripcion(materiasACursar);

        Assertions.assertTrue(inscripcion.aprobada(alumno), "El alumno cumple con las correlativas");
    }

    @Test
    public void inscripcionEsRechazada() {

        Set<Materia> materiasACursar = new HashSet<>();
        materiasACursar.add(ddsi);

        Inscripcion inscripcion = new Inscripcion(materiasACursar);

        Assertions.assertFalse(inscripcion.aprobada(alumno), "El alumno no cumple con las correlativas");
    }

}
