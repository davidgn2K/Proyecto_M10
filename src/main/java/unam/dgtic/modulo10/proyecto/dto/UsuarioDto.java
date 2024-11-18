package unam.dgtic.modulo10.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Integer id;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private char genero;
    private int edad;
    private String email;
    private String contrasena;
    private boolean esAdministrador; 
    private String ciudad;
    private String linkCV;
}
