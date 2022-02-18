package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

public class ItemModel {
    private int id;
    private BooksModel bookModel;
    private int quantity;

    public ItemModel() {
    }

    public ItemModel(int id, BooksModel bookModel, int quantity) {
        this.id = id;
        this.bookModel = bookModel;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BooksModel getBookModel() {
        return bookModel;
    }

    public void setBookModel(BooksModel bookModel) {
        this.bookModel = bookModel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
