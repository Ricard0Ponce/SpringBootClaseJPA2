package com.trinity.jpa.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.trinity.jpa.models.Author;
import com.trinity.jpa.services.AuthorService;
import lombok.Data;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;

@Data
@RestController
public class AuthorController {
    // Aqui es donde se crean los endpoints, con @Post,Get,Put,Delete...Mapping
    private final AuthorService authorService;

    @GetMapping("/authors/{author-name}")
    public List<Author> getByName(
            @PathVariable("author-name") String name) {
        return authorService.searchName(name);
    }

    @GetMapping("/authors/names/starts/{first-name-containing}")
    public List<Author> getAuthorsCointaining(
            @PathVariable("first-name-containing") String param) {
        return authorService.searchNamesWith(param);
    }

    @GetMapping("/authors/names/ends/{ends-with}")
    public List<Author> getAuthorsEndsWith(
            @PathVariable("ends-with") String param) {
        return authorService.searchsNamesThatEndsWith(param);
    }

    /*
     * @GetMapping("/authors/names/listnames")
     * public List<Author> getListWithListNames(
     * 
     * @RequestParam List<String> param) {
     * return authorService.searchListNames(param);
     * }
     */
    // El endpoint se usa como:
    // http://localhost:8080/authors/names/search?firstnames=Trent,Renato,Wilfredo,Lorie
    @GetMapping("/authors/names/search")
    public List<Author> searchAuthorsByNames(@RequestParam List<String> firstnames) {
        return authorService.searchListNames(firstnames);
    }

    @PutMapping("/authors/{id}/age")
    public int updateAge(@PathVariable("id") int id, @RequestParam("age") int age) {
        return authorService.update(age, id);
    }

    @GetMapping("/authors/names/ages/{age}")
    public List<Author> getAuthorsByAgeMoreThan(
            @PathVariable("age") int param) {
        return authorService.findByNameQ(param);
    }

}
