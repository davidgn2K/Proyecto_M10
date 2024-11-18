package unam.dgtic.modulo10.proyecto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Catalogoestatus")
@Data
@NoArgsConstructor
public class Estatus {
    @Id
    @Column(name = "cveestatus")
    private Integer cveEstatus;
    private String descripcion;
}
