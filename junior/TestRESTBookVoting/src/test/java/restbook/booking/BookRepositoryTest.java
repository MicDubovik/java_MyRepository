package restbook.booking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import restbook.model.Book;
import restbook.repository.BookRepository;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestEntityManager
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void whenfindAllGetFirstBookTitle() {

        this.entityManager.persist(new Book("testname", "testauthor", "testgenre"));
        List<Book> books = this.repository.findAll();
        Book book = books.get(0);
        assertThat(book.getTitle()).isEqualTo("testname");

    }

    @Test
    public void whenFindAllByRatingGetFirstBookTitle() {

        Book book = new Book("testname", "testauthor", "testgenre", 99);
        this.entityManager.persist(book);
        List<Book> books = this.repository.findAllByRating(99);
        Book result = books.get(0);
        assertThat(result.getTitle()).isEqualTo("testname");

    }

    @Test
    public void whenFindAllByIdGetAllBookAndGetBookById() {

        Book book = new Book("testname", "testauthor", "testgenre", 99);
        this.entityManager.persist(book);
        List<Book> books = this.repository.findAll();

        Integer id = books.get(0).getId();
        Book result = this.repository.findBookById(id);

        assertThat(result.getTitle()).isEqualTo("testname");

    }

    @Test
    public void whenDeleteByIdGetContainsBooklist() {

        Book book = new Book("testname", "testauthor", "testgenre", 99);
        Book book2 = new Book("testname", "testauthor", "testgenre", 100);
        this.entityManager.persist(book);
        this.entityManager.persist(book2);
        List<Book> books = this.repository.findAll();
        List<Book> result = new ArrayList<>();
        result.add(book);

        Integer id = books.get(1).getId();
          this.repository.deleteBookById(id);

         List<Book> afterDel = this.repository.findAll();

        assertThat(afterDel).isEqualTo(result);

    }

}


