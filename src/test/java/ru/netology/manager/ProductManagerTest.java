package ru.netology.manager;

import org.junit.jupiter.api.AfterEach;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import org.mockito.Mockito;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import ru.netology.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class ProductManagerTest {
    private ProductRepository repository = Mockito.mock(ProductRepository.class);
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1, "Paper Book", 308, "John R. R. Tolkien", "The Hobbit");
    private Smartphone second = new Smartphone(2, "iPhone 11", 1000, "55000", "Apple");
    private Book third = new Book(3, "Book", 300, "George Orwell", "1984");
    private Smartphone fourth = new Smartphone(4, "Nokia", 17000, "1710", "Nokia");
    private Book fifth = new Book(5, "School book", 365, "Chernyshova", "Enjoy Reading");
    private Smartphone sixth = new Smartphone(6, "LG", 16000, "TCL 20 Pro", "LG");
    private Smartphone seventh = new Smartphone(7, "Galaxy ", 1000, "S5", "Samsung");
    private Smartphone eighth = new Smartphone(8, "Nokia", 18000, "1720", "Nokia");
    private Book ninth = new Book(9, "Paper Book", 308, "John R. R. Tolkien", "The Hobbit 2");

    @BeforeEach
    public void createRepository() {
        Product[] repo = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth};
        doReturn(repo).when(repository).findAll();
    }

    @AfterEach
    public void verifyMock() {
        verify(repository).findAll();
    }

    @Test
    public void shouldNoMatchesBook() {
        Product[] actual = manager.searchBy("Tolstoi ");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNoMatchesSmartphone() {
        Product[] actual = manager.searchBy("HTC");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneMatchesBookAuthor() {
        Product[] actual = manager.searchBy("George Orwell");
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneMatchesBookName() {
        Product[] actual = manager.searchBy("School book");
        Product[] expected = new Product[]{fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneMatchesSmartphoneName() {
        Product[] actual = manager.searchBy("iPhone 11");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOneMatchesSmartphoneManufacturer() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTwoMatchesBookAutor() {
        Product[] actual = manager.searchBy("John R. R. Tolkien");
        Product[] expected = new Product[]{first, ninth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTwoMatchesSmartphoneManufacturer() {
        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = new Product[]{fourth, eighth};
        assertArrayEquals(expected, actual);
    }


}