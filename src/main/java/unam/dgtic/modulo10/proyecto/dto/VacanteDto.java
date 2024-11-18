package unam.dgtic.modulo10.proyecto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VacanteDto {
    private int id;
    private String ciudad;
    private String descripcion;
    private String titulo;
    private String empresa;
}