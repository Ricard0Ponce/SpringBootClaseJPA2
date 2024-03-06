package com.trinity.jpa.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
//10:31:42
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
/*
 * Agregamos tambien todas las etiquetas que nos permiten darle funcionalidad a las entidades
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder // Esto es experimental, le da a todas las entidades que extienden de aqui el Builder 
@MappedSuperclass //  Indica que esta clas es una superclase, no sera una entidad
public class BaseEntity { //Esta es solo una clase, no va a persistir esta clase y no sera mapeada, sirve para agregar al resto de entidades valores que pueden tener en comun 
    /*Como en todas nuestras clases declaramos el ID para 
     * las entidades igual decidimos agregarlo aquí para no repetir código
     */
    @Id
    @GeneratedValue
    private Integer id; 

    private LocalDateTime createdAt;
    private LocalDate lastModified; 
    private String createdBy;
    private String lastModifiedBy;
}
