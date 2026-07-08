package com.shopeasy.tienda.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe ingresar el nombre")
    private String nombre;

    @NotBlank(message = "Debe ingresar la descripción")
    private String descripcion;

    @NotNull(message = "Debe ingresar un precio")
    @Positive(message = "El precio debe ser mayor que cero")
    private Double precio;

    @NotNull(message = "Debe ingresar el stock")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    private String imagen;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}