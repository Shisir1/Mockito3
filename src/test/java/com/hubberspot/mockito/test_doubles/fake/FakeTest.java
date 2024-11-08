package com.hubberspot.mockito.test_doubles.fake;

import com.hubberspot.mockito.test_doubles.dummy.DummyEmailService;
import com.hubberspot.mockito.test_doubles.dummy.EmailService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeTest {
    @Test
    public void testFake(){
        BookRepository bookRepository = new FakeBookRepository();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepository);

        bookService.addBook(new Book("1234", "Mockito in Action", 250, LocalDate.now()));
        bookService.addBook(new Book("1235", "JUnit in Action", 200, LocalDate.now()));

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
