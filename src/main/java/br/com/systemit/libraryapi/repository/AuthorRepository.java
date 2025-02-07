package br.com.systemit.libraryapi.repository;

import br.com.systemit.libraryapi.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
