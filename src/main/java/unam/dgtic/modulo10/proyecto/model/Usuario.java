package unam.dgtic.modulo10.proyecto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuarios")
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @Column(name = "idusuario") 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @Column(name = "appaterno") 
    private String apPaterno;
    @Column(name = "apmaterno") 
    private String apMaterno;
    private char genero;
    private int edad;
    private String email;
    private String contrasena;
    @Column(name = "esadministrador") 
    private boolean esAdministrador; 
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cveciudad")
    private Ciudad ciudad;
    @Column(name = "linkcv") 
    private String linkCV;

    public void setLinkCV(String linkCV) {
        this.linkCV = linkCV;
    }

    public String getLinkCV() {
        return linkCV;
    }

    @Override
public String toString() {
    return "Usuario{" +
            ", nombre='" + nombre + '\'' +
            ", apPaterno='" + apPaterno + '\'' +
            ", apMaterno='" + apMaterno + '\'' +
            ", genero=" + genero +
            ", edad=" + edad +
            ", email='" + email + '\'' +
            ", contrasena='[PROTECTED]'" +  // You may want to avoid printing sensitive information like 'contrasena'
            ", linkCV='" + linkCV + '\'' +
            '}';
}
}