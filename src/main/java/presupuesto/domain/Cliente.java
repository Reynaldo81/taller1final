package presupuesto.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private Long id;
    private String nombres;
    private String apellidos;
    private String ruc;
    private String email;
    private String telefono;
}
