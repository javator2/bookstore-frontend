package com.example.bookstorefrontend;

import com.example.bookstorefrontend.login.Role;
import com.example.bookstorefrontend.login.RoleRepository;
import com.example.bookstorefrontend.login.User;
import com.example.bookstorefrontend.login.UserRepository;
import com.example.bookstorefrontend.model.Books;
import com.example.bookstorefrontend.service.BookApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookstoreFrontendApplication implements CommandLineRunner {

	@Autowired
	private BookApiClient client;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreFrontendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(client.fetchAllBooks());
//		Books books = client.fetchAllBooks();
//		books.getBooks().forEach(
//				book -> System.out.println(client.fetchBookInfo(book.getId()))
//		);

		Role adminRole = roleRepository.save(new Role("ADMIN"));
		Role userRole = roleRepository.save(new Role("USER"));

		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);

		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);

		userRepository.save(new User("admin", "{noop}admin", adminRoles));
		userRepository.save(new User("user", "{noop}user", userRoles));

		userRepository.findByUsername("user").ifPresent(System.out::println);
		System.out.println(roleRepository.findRolesByUsername("user"));
//		System.out.println(userRepository.findByUsername("user"));
	}
}
