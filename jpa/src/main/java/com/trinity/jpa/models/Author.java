package com.trinity.jpa.models;

import java.util.List;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Cuando hacemos el id de la tabla se usa la importacion de Jakarta
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Table(name = "AUTHOR_TBL") /* name ="" nos permite definir el nombre de la tabla */

@Data // Genera Gettes, Setters, hashCode, ToString..etc
@NoArgsConstructor // Esta anotación genera un constructor sin argumentos en tiempo de
                   // compilación, lo que significa que no necesitas escribirlo explícitamente en
                   // tu código.
@Entity // se utiliza para marcar una clase como una entidad JPA Esto significa que la
        // clase está asociada con una tabla en la base de datos y que los objetos de
        // esta clase pueden ser almacenados y recuperados de la base de datos.
@AllArgsConstructor // Le pide al constructor todos los argumentos
@Builder // Patron que nos ayuda a instancia de este objeto en otras clases
// NamedQuery nos permite crear consultas para una entidad sin necesidad de
// especificar codigo más allá de la consulta que se hara
@NamedQuery(name = "Author.findByNamedQuery", query = "select a from Author a where a.age >= :age")

public class Author {
        @Id // Hacemos que este ID sea una llave primaria de esta identidad
        @GeneratedValue // (strategy = GenerationType.AUTO) // Especifica cómo se generará
                        // automáticamente el valor de una
                        // columna de clave primaria (ID) en una entidad JPA cuando se
                        // inserta un nuevo registro en la base de datos.
        /*
         * Forma en la que se hace de manera manual
         * 
         * @GeneratedValue(strategy = GenerationType.SEQUENCE,
         * generator = "author_sequence")
         * 
         * @SequenceGenerator(name = "author_sequence",
         * sequenceName = "author_sequence",
         * allocationSize = 1)
         */

        private Integer id;
        @Column(name = "f_name", length = 35) // name Permite mapear la columna para la BD de este atributo
                                              // length permite definir el tamaño de la cadena de este campo, en este
                                              // caso
                                              // maximo de 35
        private String firtsname;
        private String lastName;
        @Column(unique = false, nullable = false) // Con Unique=false indicamos que el correo es unico, es decir, no
                                                  // puede
                                                  // haber correos duplicados
                                                  // Con nullable = false indicamos que la columna correspondiente en la
                                                  // base de datos no puede contener valores nulos y que siempre debe
                                                  // tener
                                                  // un valor válido.
        private String email;
        private int age;
        /*
         * @Column(updatable = false, nullable = false) // Con updatable = false
         * indicamos que el registro de este campo no
         * // podrá ser cambiado
         * private LocalDateTime createdAt;
         * 
         * /*
         * indicar que la columna correspondiente en la base de datos no debe ser
         * considerada al insertar nuevos registros en la tabla.
         * Esta columna podría ser actualizada automáticamente por la base de datos o
         * por tu aplicación en un momento posterior, pero no se tomará en cuenta
         * durante la inserción inicial.
         * 
         * @Column(insertable = false)
         * private LocalDate lastModified;
         * 
         */
        @ManyToMany(mappedBy = "authors") // Definimos al "Dueño" de esa relacion, que es responsable de la llave
                                          // foranea
        // Se debe poner el nombre del atributo que los relaciona en la otra tabla
        private List<Course> courses;

}
