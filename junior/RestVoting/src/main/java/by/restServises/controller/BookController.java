package by.restServises.controller;


import by.restServises.model.Book;
import by.restServises.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookController  {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/first")
    public String show(){
//       ModelAndView view = new ModelAndView("public/API/views/home.html");

       return "templates/";
    }

    @RequestMapping("/fill")
    public ModelAndView getPage(){

        Book book = new Book("The Dead Key","D. M. Pulley","Thrillers & Suspense",0);
        Book book1 = new Book("Thunderball (James Bond)","Ian Fleming","Thrillers & Suspense",0);
        Book book2 = new Book("The Secret of Spellshadow Manor","Bella Forrest","Fiction",0);
        Book book3 = new Book("Milk and Honey","Rupi Kaur","Fiction",0);
        Book book4 = new Book("The Odds of Loving Grover Cleveland","Rebekah Crane","Romance",0);
        Book book5 = new Book("Wives of War","Soraya M. Lane","Romance",0);
        Book book6 = new Book("The Curse: Touch of Eternity","Emily Bold, Jeanette Heron","Romance",0);
        Book book7 = new Book("The Secret of Spellshadow Manor","Bella Forrest","Fantasy",0);

        bookRepository.save(book);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);
        bookRepository.save(book6);
        bookRepository.save(book7);

        ModelAndView model=new ModelAndView("index");
        return  model;
    }
}
