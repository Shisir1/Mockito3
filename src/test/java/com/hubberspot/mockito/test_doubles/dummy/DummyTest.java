package com.hubberspot.mockito.test_doubles.dummy;


import org.junit.jupiter.api.Test;

import static java.time.LocalDate.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    public void demoDummy(){
        BookRepository bookRepository = new FakeBookRepository();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepository, emailService);

        bookService.addBook(new Book("1234", "Mockito in Action", 250, now()));
        bookService.addBook(new Book("1235", "JUnit in Action", 200, now()));

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
