package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.sql.Timestamp;

public class BooksDiscountsModel {
    private String bookIsbn;
    private long discountId;

    public BooksDiscountsModel() {
    }

    public BooksDiscountsModel(String bookIsbn, long discountId) {
        this.bookIsbn = bookIsbn;
        this.discountId = discountId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(long discountId) {
        this.discountId = discountId;
    }

    @Override
    public String toString() {
        return "BooksDiscountsModel{" +
                "bookIsbn='" + bookIsbn + '\'' +
                ", discountId=" + discountId +
                '}';
    }
}
