package restbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import restbook.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByRating(Integer rating);

    List<Book> findAll();

    Book findBookById(Integer id);

    void deleteBookById(Integer id);

    @Modifying
    @Query(value = "UPDATE Book  SET rating = :rating+1  WHERE id = :id", nativeQuery = true)
    @Transactional
    void setRating(@Param("id") Integer id,
                   @Param("rating") Integer rating);

}
