package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.sql.Timestamp;

public class BookGenresModel {
    private String bookIsbn;
    private long genreId;

    public BookGenresModel() {
    }

    public BookGenresModel(String bookIsbn, long genreId, Timestamp createDate) {
        this.bookIsbn = bookIsbn;
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "BookGenresModel{" +
                "bookIsbn='" + bookIsbn + '\'' +
                ", genreId=" + genreId +
                '}';
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }
}
