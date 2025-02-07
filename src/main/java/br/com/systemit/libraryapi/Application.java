package br.com.systemit.libraryapi;

import br.com.systemit.libraryapi.model.Author;
import br.com.systemit.libraryapi.repository.AuthorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*var context = SpringApplication.run(Application.class, args);
		AuthorRepository repository = context.getBean(AuthorRepository.class);
		exemploSalvarRegistro(repository);*/
	}

	/*private static void exemploSalvarRegistro(AuthorRepository repository) {
		Author author = new Author();
		author.setName("Jose");
		author.setNationality("Brazilian");
		author.setBirthDate(LocalDate.of(1950, 1, 11));
		author.setName("Jose");

		repository.save(author);

		System.out.println("Author: " + author);
	}*/

}
