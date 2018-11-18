package com.example.bookstorefrontend;

import com.example.bookstorefrontend.model.Books;
import com.example.bookstorefrontend.service.BookApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreFrontendApplication implements CommandLineRunner {

	@Autowired
	private BookApiClient client;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreFrontendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(client.fetchAllBooks());
		Books books = client.fetchAllBooks();
		books.getBooks().forEach(
				book -> System.out.println(client.fetchBookInfo(book.getId()))
		);
	}
}
