package com.hubberspot.mockito.test_doubles.spy;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpyTest {

    // Spy is similar to Stub but it also has additional feature
    //of recording the events like external calls and all, in this
    //example, we are simply saving the book in the repository but
    // we can't really tell whether book was actually added or not
    //so, in this case we can use spy to track the calls and test its
    //behavior.
    @Test
    public void demoSpy(){
        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositorySpy);

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit in Action", 400, LocalDate.now());

        bookService.addBook(book1);
        assertEquals(0, bookRepositorySpy.timesCalled());

        bookService.addBook(book2);
        assertEquals(1, bookRepositorySpy.timesCalled());

        //assertTrue(bookRepositorySpy.calledWith(book2));
    }
}
