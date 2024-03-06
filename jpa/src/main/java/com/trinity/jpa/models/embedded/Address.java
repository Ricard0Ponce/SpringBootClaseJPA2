package com.trinity.jpa.models.embedded;

import jakarta.persistence.Embeddable;
// Esto sera una entidad embebida que permitira agregar informacion adicional a una entidad
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable // Agregamos la etiqueta para la entidad Embebida
public class Address {
    private String street;
    private String houserNumber; 
    private String zipCode; 

}