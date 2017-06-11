package restbook.controller;

import org.jsondoc.core.annotation.ApiPathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restbook.model.Book;
import restbook.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET ,produces = "application/json")
    public List<Book> getAll() {

        return bookRepository.findAll();
    }

    @RequestMapping(value = "/rating/{rating}", method = RequestMethod.GET)
    public List<Book> getByRating(@ApiPathParam(name = "rating") @PathVariable Integer rating) {
        return bookRepository.findAllByRating(rating);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Book> create(@RequestBody Book book ) {
        Book book1 = book;
        bookRepository.save(book);

        return bookRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<Book> remove(@ApiPathParam(name = "id") @PathVariable Integer id) {
        bookRepository.deleteBookById(id);

        return bookRepository.findAll();
    }

    @RequestMapping(value = "/addvote/{id}", method = RequestMethod.PUT)
    public Optional<List<Book>> addVoice(@ApiPathParam(name = "id") @PathVariable Integer id) {


        Book book2 = bookRepository.findBookById(id);


            bookRepository.setRating(id, book2.getRating()+1);


        Optional<List<Book>> list = Optional.ofNullable(bookRepository.findAll());


        return list;
    }
}