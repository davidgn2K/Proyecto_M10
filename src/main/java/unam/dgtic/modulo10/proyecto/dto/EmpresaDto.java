package unam.dgtic.modulo10.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDto {
    private Integer idEmpresa;
    private String nombre;
    private String sitioWeb;
    private Integer numEmpleados;
    private String sector;
    private boolean verificada;
}
