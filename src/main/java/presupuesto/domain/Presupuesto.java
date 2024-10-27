package presupuesto.domain;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Presupuesto {
    private Long id;
    private LocalDate fecha;
    private Cliente cliente;
    private Double montoTotal;
    private Double montoPresupuestado;
    private String estado;
}
