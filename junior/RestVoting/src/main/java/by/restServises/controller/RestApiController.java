package by.restServises.controller;


import by.restServises.model.Book;
import by.restServises.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestApiController {

    @Autowired
    BookRepository bookRepository;


    @RequestMapping("/api/getAll")
    public @ResponseBody List<Book> getAllBook(){

        List<Book> bookList = bookRepository.findAll();

        return bookList;
    }

    @RequestMapping("/api/getAllById")
    public List<Book> getAllBookById(@RequestParam("id")Integer id){
        List<Book> bookList = bookRepository.findAllById(id);

        return bookList;
    }

    @RequestMapping("/api/getAllByAuthor")
    public List<Book> getBookByAuthor(@RequestParam("author")String author){
        List<Book> bookList = bookRepository.findAllByAuthor(author);

        return bookList;
    }

    @RequestMapping("/api/getAllByRating")
    public List<Book> getBookByRating(@RequestParam("rating")String rating){
        List<Book> bookList = bookRepository.findAllByRating(rating);

        return bookList;
    }

    @RequestMapping("/api/getAllByGenre")
    public List<Book> getBookByGenre(@RequestParam("genre")String genre){
        List<Book> bookList = bookRepository.findAllByGenre(genre);

        return bookList;
    }


    @RequestMapping(value = "/api/putBook",method = RequestMethod.POST)
    public String putBook(@RequestParam("title")String title,
                              @RequestParam("author")String author,
                              @RequestParam("genre")String genre ){
        bookRepository.save(new Book(title, author, genre));

        return "Success add book !";

    }

//    @RequestMapping(value = "/api/updateBook",method = RequestMethod.PUT)
//    public Optional<String> updateBook(@RequestParam("title")String title,
//                                       @RequestParam("author")String author){
//
////        boolean result = bookRepository.updateBook(title,author);
////        String response = null;
////        if (result){
////            response="Update successful !";
////        }
////        Optional<String> optional= Optional.ofNullable(response);
//
//        return optional;
//    }

    @RequestMapping(value = "/api/delete",method = RequestMethod.DELETE)
    public String deleteBookById(@RequestParam("id")Integer id){

        bookRepository.deleteBookById(id);

        return "Delete successful !";

    }




}
