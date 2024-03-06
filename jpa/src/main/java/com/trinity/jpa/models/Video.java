package com.trinity.jpa.models;

//import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
//import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
// @PrimaryKeyJoinColumn(name = "video_id") // Permite darle nombre a la tabla
// que se almacena en la entidad de Video, SOLO FUNCIONA CON JOINED
// @DiscriminatorValue("V") // Se usa solo cuando usamos SINGLE_TABLE
public class Video extends Resource {
    private int lenght;

}
