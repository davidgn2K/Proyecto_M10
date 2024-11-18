package unam.dgtic.modulo10.proyecto.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalogoestados")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cveestado")
    private Integer id;
    private String descripcion;
    @JsonManagedReference
    @OneToMany(mappedBy = "estado")
    private Set<Ciudad> ciudades;


    public Estado(){}

    public Estado(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "{ Id: " + id + ", descripcion: " + descripcion;
    }
}
