package presupuesto.service;


import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import presupuesto.domain.Cliente;
import presupuesto.repository.ClienteRepository;

@ApplicationScoped
public class ClienteService {
    @Inject
    ClienteRepository clienteRepository;

    public List<Cliente> buscarPorNombresYApellidos(String nombres, String apellidos) {
        return clienteRepository.buscarPorNombresYApellidos(nombres, apellidos);
    }
}
