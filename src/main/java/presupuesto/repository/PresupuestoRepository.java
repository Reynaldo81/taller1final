package presupuesto.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import presupuesto.domain.Presupuesto;

@ApplicationScoped
public class PresupuestoRepository {
    private final List<Presupuesto> presupuestos = new ArrayList<>();

    public int count() {
        return presupuestos.size();
    }

    public List<Presupuesto> findByMontoPresupuestadoBetween(Double rangoInicial, Double rangoFinal) {
        return presupuestos.stream()
                .filter(p -> p.getMontoPresupuestado() >= rangoInicial && p.getMontoPresupuestado() <= rangoFinal)
                .collect(Collectors.toList());
    }

    public List<Presupuesto> findHighestPresupuesto() {
        if (presupuestos.isEmpty()) {
            return new ArrayList<>();
        }

        Double maxMonto = presupuestos.stream()
                .map(Presupuesto::getMontoPresupuestado)
                .max(Comparator.naturalOrder())
                .orElse(0.0);

        return presupuestos.stream()
                .filter(p -> p.getMontoPresupuestado().equals(maxMonto))
                .collect(Collectors.toList());
    }
}