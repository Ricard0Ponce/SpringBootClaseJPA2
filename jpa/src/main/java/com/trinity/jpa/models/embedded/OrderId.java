package com.trinity.jpa.models.embedded;
// En esta clase creamos IDs embebidos 
// Los IDs embebidos se caracterisan por tener 2 atributos relacionados que juntos hacen unico a un registro

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Esta es una entidad que no sera persisitida(Similar a la superclase que vimos anteriormente )
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable // Esta es la anotacion que nos permite realizar la entidad embebida
// Se debe agregar el "Serialazable"
public class OrderId implements Serializable{
    private String username;
    private LocalDateTime date;
    
}
