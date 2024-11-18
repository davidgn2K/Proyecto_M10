package unam.dgtic.modulo10.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuario_Vacante")
@IdClass(UsuarioVacantePK.class)
@NoArgsConstructor
public class UsuarioVacante {
    @Id
    @Column(name = "idusuario") 
    private int idUsuario;
    @Id
    @Column(name = "idvacante") 
    private int idVacante;
    @ManyToOne
    @JoinColumn(name = "cveestatus")
    private Estatus estatus;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idvacante")
    private Vacante vacante;

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public Estatus getEstatus() {
        return estatus;
    }
}
