package com.trinity.jpa.models.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // Esta si es una entidad y sera persistida
@Table(name = "_order")
public class Order { // Esta clase tendra un ID especificado por nosotros, en este caso es un "ID
                     // Embebido" que especificamos en la clase OrderId
    @EmbeddedId // Esta etiqueta permite agregar el ID embebido
    private OrderId id;
    private String orderInfo;
    private String anotherField;
    // Agregamos un atributo para la entidad embebida 
    @Embedded // Agregamos la etiqueta para decir que estamoa agregando una entidad embebida
    private Address address;
}
