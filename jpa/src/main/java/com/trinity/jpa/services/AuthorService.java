package com.trinity.jpa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trinity.jpa.data.AuthorRepository;
import com.trinity.jpa.models.Author;

import jakarta.transaction.Transactional;
import lombok.Data;

@Data
@Service
public class AuthorService {
    // Solo se declara el metodo a inyectar, gracias a Lombook con @Data ya no es
    // necesario usar el constructor
    private final AuthorRepository authorRepository;
    // Si se usa DTO aqui se agrega la dependencia del Mapper que realiza la
    // transformacio

    public List<Author> searchName(String name) {
        return authorRepository.findAllByFirtsnameContainingIgnoreCase(name);
    }

    // Agregar el resto de endpoints y buscar como es que sirve el IMapper
    // Este metodo devuelve la lista de personas que empiezan por la letra que se
    // introduce en el campo
    public List<Author> searchNamesWith(String name) {
        return authorRepository.findAllByFirtsnameStartsWithIgnoreCase(name);
    }

    // Busca los elementos que terminan con el parametro pasado
    public List<Author> searchsNamesThatEndsWith(String name) {
        return authorRepository.findAllByFirtsnameEndsWithIgnoreCase(name);
    }

    // Dada una lista, busca a esos autores
    public List<Author> searchListNames(List<String> firstnames) {
        return authorRepository.findAllByFirtsnameInIgnoreCase(firstnames);
    }

    // Permite actualizar la edad de uno de nuestrs autores
    @Transactional /*
                    * Notas sobre esta etiqueta:
                    * e encarga de gestionar la transacción automáticamente. Esto incluye iniciar
                    * la transacción antes de que comience la ejecución del método y realizar un
                    * commit al finalizar el método si la ejecución fue exitosa, o realizar un
                    * rollback si se produce una excepción.
                    */
    public int update(int age, int id) {
        return authorRepository.updateAuthor(age, id);
    }

    public List<Author> findByNameQ(int age) {
        return authorRepository.findByNamedQuery(age);
    }

}
