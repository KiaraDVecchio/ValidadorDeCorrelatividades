package domain;

import java.util.HashSet;
import java.util.Set;

public class Materia {
    private String nombre;
    private Set<Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new HashSet<>();
    }

    public Set<Materia> getCorrelativas() {
        return correlativas;
    }

    public boolean cumpleCorrelativas(Set<Materia> materiasAprobadas) {
        return materiasAprobadas.containsAll(correlativas);
    }
}

