package presupuesto.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import presupuesto.domain.Cliente;

@ApplicationScoped
public class ClienteRepository {
    private final List<Cliente> clientes = new ArrayList<>();

    public ClienteRepository() {
        // Datos de ejemplo
        clientes.add(new Cliente(1L, "Juan", "Perez", "123456", "juan@mail.com", "123456"));
        clientes.add(new Cliente(2L, "Maria", "Gomez", "789012", "maria@mail.com", "789012"));
    }

    public List<Cliente> buscarPorNombresYApellidos(String nombres, String apellidos) {
        return clientes.stream()
                .filter(cliente -> 
                    (nombres == null || cliente.getNombres().toLowerCase().contains(nombres.toLowerCase())) &&
                    (apellidos == null || cliente.getApellidos().toLowerCase().contains(apellidos.toLowerCase())))
                .collect(Collectors.toList());
    }
}