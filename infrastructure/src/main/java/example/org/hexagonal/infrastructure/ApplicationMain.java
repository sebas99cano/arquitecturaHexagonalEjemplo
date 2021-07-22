package example.org.hexagonal.infrastructure;

import example.org.hexagonal.application.ConsoleApp;
import example.org.hexagonal.domain.services.BooksService;
import example.org.hexagonal.domain.services.BooksServiceFactory;

public class ApplicationMain {
    public static void main(String[] args) {
        BooksService booksService = BooksServiceFactory.getBooksService(new BooksRepositoryImpl());
        ConsoleApp consoleApp = new ConsoleApp(System.console(), booksService);
        consoleApp.waitForCommand();
    }
}
