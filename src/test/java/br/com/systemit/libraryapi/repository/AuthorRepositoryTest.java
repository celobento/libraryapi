package br.com.systemit.libraryapi.repository;

import br.com.systemit.libraryapi.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    public void salvarTest() {
        Author author = new Author();
        author.setName("Maria");
        author.setNationality("Brazilian");
        author.setBirthDate(LocalDate.of(1950, 1, 11));

        authorRepository.save(author);

        System.out.println("Author: " + author);
    }

}
