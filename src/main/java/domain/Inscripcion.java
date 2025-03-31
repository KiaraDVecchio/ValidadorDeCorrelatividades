package domain;

import java.time.LocalDateTime;
import java.util.Set;

public class Inscripcion {
    private Set<Materia> materiasACursar;
    private boolean fueAprobada;
    private LocalDateTime fechaDeEvaluacion;

    public Inscripcion(Set<Materia> materiasACursar) {
        this.materiasACursar = materiasACursar;
        this.fueAprobada = false;
        this.fechaDeEvaluacion = null;
    }

    public Set<Materia> getMateriasACursar() {
        return materiasACursar;
    }

    public boolean aprobada(Alumno alumno) {
        this.fueAprobada = materiasACursar.stream().allMatch(materia -> alumno.cumpleCorrelativas(materia));
        return fueAprobada;
    }
}
