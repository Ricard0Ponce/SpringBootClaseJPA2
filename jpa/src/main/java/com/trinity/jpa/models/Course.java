package com.trinity.jpa.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    // La anotación @ManyToMany indica una relación muchos a muchos entre Course y
    // Author
    @ManyToMany
    @JoinTable(name = "authors_courses", // Nombre de la tabla intermedia
            joinColumns = { @JoinColumn(name = "course_id") }, // Columna que referencia a Course en la tabla intermedia
            inverseJoinColumns = { @JoinColumn(name = "author_id") }) // Columna que referencia a Author en la tabla
                                                                      // intermedia
    private List<Author> authors; // Lista de autores del curso
    // Un curso tiene muchas secciones, por lo que agregamos una lista de secciones
    @OneToMany(mappedBy = "course") //UN Curso tiene MUCHAS SECCIONES
    private List<Section> sections;

}//10:05:30
