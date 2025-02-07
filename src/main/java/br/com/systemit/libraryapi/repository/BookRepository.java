package br.com.systemit.libraryapi.repository;

import br.com.systemit.libraryapi.model.Author;
import br.com.systemit.libraryapi.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

    // query method
    List<Book> findByAuthor(Author author);
    List<Book> findByTitulo(String titulo);
    List<Book> findByTituloAndPrice(String titulo, BigDecimal price);
    List<Book> findByTituloOrPrice(String titulo, BigDecimal price);

    @Query("select o from Livro o order by o.title")
    List<Book> buscaTodos();

    @Query("select o from Livro o where o.title = :title order by o.title")
    List<Book> buscaTodosPorTitulo(@Param("title") String title);

    @Query("select o from Livro o where o.title = ?1 order by o.title")
    List<Book> buscaTodosPorParameter(String title);

    @Query("""
        select o from Livro o
        order by o.title
    """)
    List<Book> buscaTodosOrdenados();

    @Modifying
    @Transactional
    @Query("delete from Book where title = ?1")
    void deleteByTitle(String title);
}

