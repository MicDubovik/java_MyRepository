package by.restServises.repository;


import by.restServises.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAll();
    List<Book> findAllById(Integer id);
    List<Book> findAllByAuthor(String author);
    List<Book> findAllByRating(String rating);
    List<Book> findAllByGenre(String genre);
    boolean deleteBookById(Integer id);


//    @Modifying
//    @Query("update Book  set author = :author  where title = :title")
//    @Transactional
//    boolean updateBook(@Param("title")String title,
//                       @Param("author") String author);


}
