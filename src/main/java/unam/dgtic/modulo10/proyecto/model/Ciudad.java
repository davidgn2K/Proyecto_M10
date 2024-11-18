package unam.dgtic.modulo10.proyecto.model;

import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Catalogociudades")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cveciudad")
    private Integer id;
    private String descripcion;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cveestado")
    private Estado estado;

    @JsonManagedReference
    @OneToMany(mappedBy = "ciudad")
    private Set<Usuario> usuarios = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "ciudad")
    private Set<Vacante> vacantes = new HashSet<>();

    public Ciudad(){}

    public Ciudad(Integer id, String descripcion, Estado estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "{ Id: " + id + ", descripcion: " + descripcion;
    }
}
