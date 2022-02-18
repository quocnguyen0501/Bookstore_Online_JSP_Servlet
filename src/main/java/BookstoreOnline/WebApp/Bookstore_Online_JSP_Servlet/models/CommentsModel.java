package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.sql.Timestamp;

public class CommentsModel {
    private int id;
    private String bookIsbn;
    private int userId;
    private int ratingId;
    private String comment;
    private Timestamp date;

    public CommentsModel() {
    }

    public CommentsModel(int id, String bookIsbn, int userId, int ratingId, String comment, Timestamp date) {
        this.id = id;
        this.bookIsbn = bookIsbn;
        this.userId = userId;
        this.ratingId = ratingId;
        this.comment = comment;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CommentsModel{" +
                "id=" + id +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", userId=" + userId +
                ", ratingId=" + ratingId +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
