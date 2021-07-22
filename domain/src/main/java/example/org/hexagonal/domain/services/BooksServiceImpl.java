package example.org.hexagonal.domain.services;

import example.org.hexagonal.domain.data.Book;
import example.org.hexagonal.domain.repo.BooksRepository;
import example.org.hexagonal.domain.services.BooksService;

import java.util.UUID;

public class BooksServiceImpl implements BooksService {
    private final BooksRepository booksRepository;
    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
    @Override
    public UUID createBook(String name, String author, String description) {
        final Book book = new Book(UUID.randomUUID(), name, author, description);
        booksRepository.save(book);

        return book.getId();
    }

    @Override
    public void deleteBook(UUID id) {
        booksRepository.delete(id);
    }
}
