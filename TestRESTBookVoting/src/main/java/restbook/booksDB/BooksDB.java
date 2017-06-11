package restbook.booksDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import restbook.model.Book;
import restbook.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class BooksDB implements CommandLineRunner {

    private BookRepository bookRepository;

    @Autowired
    public BooksDB(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Book> books = new ArrayList<>();
       books.add(new Book("The Dead Key","D. M. Pulley","Thrillers & Suspense",0));
        books.add(new Book("Thunderball (James Bond)","Ian Fleming","Thrillers & Suspense",0));
        books.add(new Book("The Secret of Spellshadow Manor","Bella Forrest","Fiction",0));
        books.add(new Book("Milk and Honey","Rupi Kaur","Fiction",0));
        books.add(new Book("The Odds of Loving Grover Cleveland","Rebekah Crane","Romance",0));
        books.add(new Book("Wives of War","Soraya M. Lane","Romance",0));
        books.add(new Book("The Curse: Touch of Eternity","Emily Bold, Jeanette Heron","Romance",0));
        books.add(new Book("The Secret of Spellshadow Manor","Bella Forrest","Fantasy",0));

        bookRepository.save(books);
    }
}
