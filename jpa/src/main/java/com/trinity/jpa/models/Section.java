package com.trinity.jpa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Section {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int sectionOrder;
    // Muchas secciones pertenecen a UN curso
    @ManyToOne // MUCHAS secciones estan relacionadas a UN curso
    @JoinColumn(name = "course_id") // Agregamos la columna course_id a la tabla de secciones, de esta manera
                                    // tendremos la llave foranea en nuestro registro y con ello la relacion
    private Course course;
    @OneToMany(mappedBy="section")
    private List<Lecture> Lectures;

}
