package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.sql.Date;
import java.sql.Timestamp;

public class BooksModel {
    private String isbn;
    private String title;
    private Date publicationDate;
    private int edition;
    private int availableQuantity;
    private double price;
    private long authorId;
    private long publisherId;
    private String image;

    public BooksModel() {
    }

    public BooksModel(String isbn, String title, Date publicationDate, int edition, int availableQuantity,
                      double price, long authorId, long publisherId, String image) {
        this.isbn = isbn;
        this.title = title;
        this.publicationDate = publicationDate;
        this.edition = edition;
        this.availableQuantity = availableQuantity;
        this.price = price;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.image = image;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return "BooksModel{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", edition=" + edition +
                ", availableQuantity=" + availableQuantity +
                ", price=" + price +
                ", authorId=" + authorId +
                ", publisherId=" + publisherId +
                ", image='" + image + '\'' +
                '}';
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
