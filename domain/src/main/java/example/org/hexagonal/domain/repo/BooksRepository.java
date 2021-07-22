package example.org.hexagonal.domain.repo;

import example.org.hexagonal.domain.data.Book;

import java.util.UUID;

public interface BooksRepository {
    void save(Book book);
    void delete(UUID id);
}
