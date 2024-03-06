package com.trinity.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.trinity.jpa.data.AuthorRepository;
//import com.trinity.jpa.models.Author;
//import com.github.javafaker.Faker;

@SpringBootApplication
@EnableTransactionManagement
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	// El siguiente metodo me permite realizar una prueba al inyectar datos a la BD
	// A esto se le llama "Transaccion"
	// @Bean // LOs beans siempre se usan en metodos publicos
	/*d
	 * public CommandLineRunner commandLineRunner(
	 * AuthorRepository repository
	 * ){
	 * return args -> {
	 * var author = Author.builder()
	 * .firtsname("Ricardo")
	 * .lastName("Ponce")
	 * .age(22)
	 * .email("ricardoponc@gmail.com")
	 * .build();
	 * repository.save(author);
	 * };
	 * }
	 */

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository) {
		return args -> {
			// Aqui generamos datos para nuestra BD gracias a la clase Faker.
			/*
			 * for (int i = 0; i < 50; i++) {
			 * Faker faker = new Faker(); // Nos permite rellenar los datos de manera
			 * simulada
			 * var author = Author.builder()
			 * .firtsname(faker.name().firstName())
			 * .lastName(faker.name().lastName())
			 * .age(faker.number().numberBetween(20, 80))
			 * .email(faker.name().username() + "@gmail.com")
			 * .build();
			 * repository.save(author);
			 * }
			 */

			/*
			 * var video = Video.builder()
			 * .name("ABC")
			 * .lenght(6)
			 * .build();
			 * videoRepository.save(video);
			 */
		};
	}

}
