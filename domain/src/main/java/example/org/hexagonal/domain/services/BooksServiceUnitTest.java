package example.org.hexagonal.domain.services;

import example.org.hexagonal.domain.repo.BooksRepository;
import example.org.hexagonal.domain.services.BooksService;
import example.org.hexagonal.domain.services.BooksServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class BooksServiceUnitTest {
    @Mock
    private BooksRepository booksRepository;

    private BooksService booksService;

    @BeforeEach
    void initialize() {
        MockitoAnnotations.initMocks(this);
        booksService = BooksServiceFactory.getBooksService(booksRepository);
    }

    @Test
    void givenValidBookParamsAreProvided_whenCreateBookMethodIsCalled_thenBookIsSavedInTheRepository() {
        UUID bookId = booksService.createBook("Harry Potter and the Philosopher’s Stone", "J.K. Rowling", "A fantasy novel");
        Mockito.verify(booksRepository, Mockito.times(1))
                .save(Mockito.any());
        Assertions.assertNotNull(bookId);
    }

    @Test
    void givenExistingBookId_whenDeleteBookMethodIsCalled_thenBookIsDeletedFromTheRepository() {
        UUID bookID = UUID.randomUUID();
        booksService.deleteBook(bookID);
        Mockito.verify(booksRepository, Mockito.times(1))
                .delete(bookID);
    }
}