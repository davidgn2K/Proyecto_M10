package unam.dgtic.modulo10.proyecto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Vacantes")
@NoArgsConstructor
@Data
public class Vacante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvacante")
    private int id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cveciudad")
    private Ciudad ciudad;
    private String descripcion;
    private String titulo;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idempresa")
    private Empresa empresa;

    @Override
    public String toString() {
    return "Vacante{" +
            "id=" + id +
            ", ciudad=" + (ciudad != null ? ciudad.getDescripcion() : "null") +
            ", descripcion='" + descripcion + '\'' +
            ", titulo='" + titulo + '\'' +
            ", empresa=" + (empresa != null ? empresa.getNombre() : "null") +
            '}';
    }
}
