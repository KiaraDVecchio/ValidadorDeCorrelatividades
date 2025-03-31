package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {
    private Alumno alumno;
    private Materia unaMateria;
    private Materia otraMateria;

    @BeforeEach
    void setUp() {
        alumno = new Alumno("Kiara", "Vecchio");
        unaMateria = new Materia("Matemática");
        otraMateria = new Materia("Fisica");
    }

    @Test
    @DisplayName("El alumno aprueba una materia y se agrega a sus materias aprobadas")
    public void agregarMateriasAprobadas() {

        alumno.agregarMateriasAprobadas(unaMateria);

        assertTrue(alumno.getMateriasAprobadas().contains(unaMateria), "La materia esta aprobada");
    }

    @Test
    @DisplayName("El alumno cumple las correlativas cuando tiene las materias requeridas")
    public void cumpleCorrelativas() {

        unaMateria.getCorrelativas().add(otraMateria);
        alumno.agregarMateriasAprobadas(otraMateria);

        assertTrue(alumno.cumpleCorrelativas(unaMateria), "El alumno cumple con las correlativas");
    }

    @Test
    @DisplayName("El alumno no cumple con las correlativas requeridas")
    public void noCumpleCorrelativas() {

        unaMateria.getCorrelativas().add(otraMateria);

        assertFalse(alumno.cumpleCorrelativas(unaMateria), "El alumno NO debería cumplir con las correlativas");
    }

}