package com.trinity.jpa.models;
//import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@EqualsAndHashCode(callSuper=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@DiscriminatorValue("F") // Permite simplificar la sintaxis en la Base de datos Se usa solo cuando usamos SINGLE_TABLE
public class File extends Resource{
    private String type; 
    
}
