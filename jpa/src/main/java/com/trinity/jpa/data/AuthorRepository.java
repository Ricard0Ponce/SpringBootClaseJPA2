package com.trinity.jpa.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trinity.jpa.models.Author;

// JPARepository tiene 2 parámetros, el objeto y el ID de la tabla, en ambos casos se pasa el tipo de dato
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    // Agregamos métodos personalizados
    // Se pueden agregar metodos que sigan una query definida con la etiqueta @query
    // uodate Author a set a.age = 22 where a.id = 1
    @Modifying // Esta anotacion se necesita para implementar el Query
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    // Consulta SQL equivalente: select * from author where first_name = 'fn'
    List<Author> findAllByFirtsname(String fn);

    // Consulta SQL equivalente: select * from author where first_name like '%fn%'
    List<Author> findAllByFirtsnameContainingIgnoreCase(String fn); // IgnoreCase hace que la búsqueda no distinga entre
                                                                    // mayúsculas y minúsculas al buscar,

    // Consulta SQL equivalente: select * from author where first_name like 'fn%'
    List<Author> findAllByFirtsnameStartsWithIgnoreCase(String fn);

    // Consulta SQL equivalente: select * from author where first_name like '%fn'
    List<Author> findAllByFirtsnameEndsWithIgnoreCase(String fn); // Busca el que termina con eso

    // Consulta SQL equivalente: select * from author where first_name in ('fn1',
    // 'fn2', 'fn3', ...)
    List<Author> findAllByFirtsnameInIgnoreCase(List<String> firsnames); // Encontrar todos los nombres de la tabla de
                                                                         // aut

    // Agregamos el NamedQuery que teniamos en la clase de autor
    List<Author> findByNamedQuery(@Param("age") int age);

}
