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
@Table(name = "Empresas")
@Data
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempresa")
    private Integer idEmpresa;
    private String nombre;
    @Column(name = "sitioweb")
    private String sitioWeb;
    @Column(name = "numempleados")
    private Integer numEmpleados;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cvesector")
    private Sector sector;
    private boolean verificada;
}
