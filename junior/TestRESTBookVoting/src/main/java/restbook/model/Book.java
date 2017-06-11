package restbook.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;
    private String author;
    private String genre;

    @Column(nullable=false)
    private Integer rating=0;


    public Book() {

    }

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;

    }

    public Book(String title, String author, String genre, Integer rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public Book(Integer id ,String title, String author, String genre, Integer rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (genre != null ? !genre.equals(book.genre) : book.genre != null) return false;
        return rating != null ? rating.equals(book.rating) : book.rating == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}

