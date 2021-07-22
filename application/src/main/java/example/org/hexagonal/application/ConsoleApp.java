package example.org.hexagonal.application;

import example.org.hexagonal.domain.services.BooksService;
import org.junit.platform.commons.util.StringUtils;

import java.io.Console;
import java.util.UUID;

public class ConsoleApp {

    private final Console console;
    private final BooksService booksService;

    public ConsoleApp(Console console, BooksService booksService) {
        this.console = console;
        this.booksService = booksService;
    }

    public void waitForCommand() {
        while (true) {
            final String command = console.readLine("Enter C to create a book, D to delete a book or E to exit the application: ");
            switch (command) {
                case "C":
                    createBookInput();
                    break;
                case "D":
                    deleteBookInput();
                    break;
                case "E":
                    return;
            }
        }
    }

    private void createBookInput() {
        final String name = console.readLine("Enter book title: ");
        final String author = console.readLine("Enter author name: ");
        final String description = console.readLine("Enter description: ");
        if (StringUtils.isBlank(name)) {
            console.writer()
                    .println("Book not created, all arguments are required!");
        } else if (StringUtils.isBlank(author)) {
            console.writer()
                    .println("Book not created, all arguments are required!");
        } else if (StringUtils.isBlank(description)) {
            console.writer()
                    .println("Book not created, all arguments are required!");
        } else {
            UUID id = booksService.createBook(name, author, description);
            console.writer()
                    .println("Book " + id + " successfully created.");
        }
    }

    private void deleteBookInput() {
        final String id = console.readLine("Enter ID: ");
        booksService.deleteBook(UUID.fromString(id));
        console.writer()
                .println("Book " + id + " successfully deleted.");
    }

}