package unam.dgtic.modulo10.proyecto.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Data
public class UsuarioVacantePK implements Serializable{
    private int idUsuario;
    private int idVacante;
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UsuarioVacantePK usuarioVacantePK)) return false;
        return idUsuario == usuarioVacantePK.idUsuario && idVacante == usuarioVacantePK.idVacante;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idVacante);
    }
}
