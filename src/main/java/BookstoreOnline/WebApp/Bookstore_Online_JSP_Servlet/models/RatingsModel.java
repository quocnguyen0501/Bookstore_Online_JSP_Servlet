package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;
import java.sql.Timestamp;

public class RatingsModel {
    private int id;
    private String bookIsbn;
    private int usersId;
    private int rating;
    private Timestamp date;

    public RatingsModel() {
    }

    public RatingsModel(int id, String bookIsbn, int usersId, int rating, Timestamp date) {
        this.id = id;
        this.bookIsbn = bookIsbn;
        this.usersId = usersId;
        this.rating = rating;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RatingsModel{" +
                "id=" + id +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", usersId=" + usersId +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }
}
