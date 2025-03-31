package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MateriaTest {
    private Materia ddsi;
    private Materia pdp;
    private Materia aed;

    @BeforeEach
    void setUp() {
        ddsi = new Materia("Diseño de Sistemas de Información");
        pdp = new Materia("Paradigmas de la Programación");
        aed = new Materia("Algoritmos y Estructuras de Datos");
    }

    @Test
    @DisplayName("El alumno tiene aprobadas las correlativas de la materia")
    void cumpleCorrelativas() {
        ddsi.getCorrelativas().add(pdp);
        ddsi.getCorrelativas().add(aed);

        Set<Materia> materiasAprobadas = new HashSet<>();
        materiasAprobadas.add(pdp);
        materiasAprobadas.add(aed);

        assertTrue(ddsi.cumpleCorrelativas(materiasAprobadas), "La materia cumple con las correlativas");
    }

    @Test
    @DisplayName("El alumno no tiene aprobadas las correlativas de la materia")
    void noCumpleCorrelativas() {
        ddsi.getCorrelativas().add(pdp);
        ddsi.getCorrelativas().add(aed);

        Set<Materia> materiasAprobadas = new HashSet<>();
        materiasAprobadas.add(pdp);

        assertFalse(ddsi.cumpleCorrelativas(materiasAprobadas), "Faltan materias correlativas aprobadas");
    }
}
