package presupuesto.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import presupuesto.domain.Presupuesto;
import presupuesto.repository.PresupuestoRepository;

@ApplicationScoped
public class PresupuestoService {
    @Inject
    PresupuestoRepository presupuestoRepository;

    public int count() {
        return presupuestoRepository.count();
    }

    public List<Presupuesto> findByMontoPresupuestadoBetween(Double rangoInicial, Double rangoFinal) {
        return presupuestoRepository.findByMontoPresupuestadoBetween(rangoInicial, rangoFinal);
    }

    public List<Presupuesto> findHighestPresupuesto() {
        return presupuestoRepository.findHighestPresupuesto();
    }
}