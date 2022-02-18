package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.sql.Timestamp;

public class OrdersDetailsModel {
    private String bookIsbn;
    private long orderId;
    private int amount;

    public OrdersDetailsModel() {
    }

    public OrdersDetailsModel(String bookIsbn, long orderId, int amount) {
        this.bookIsbn = bookIsbn;
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrdersDetailsModel{" +
                "bookIsbn='" + bookIsbn + '\'' +
                ", orderId=" + orderId +
                ", amount=" + amount +
                '}';
    }
}
