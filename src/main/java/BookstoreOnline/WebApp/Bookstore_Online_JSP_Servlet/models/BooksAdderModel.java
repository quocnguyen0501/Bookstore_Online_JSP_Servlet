package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.sql.Date;
import java.sql.Timestamp;

public class BooksAdderModel {
    private String isbn;
    private String title;
    private Date publicationDate;
    private int edition;
    private int availableQuantity;
    private double price;
    private String image;
    private String firstName;
    private String secondName;
    private String companyName;
    private String publisherName;

    public BooksAdderModel() {
    }

    public BooksAdderModel(String isbn, String title, Date publicationDate, int edition, int availableQuantity,
                           double price, String image, String firstName, String secondName, String companyName,
                           String publisherName) {
        this.isbn = isbn;
        this.title = title;
        this.publicationDate = publicationDate;
        this.edition = edition;
        this.availableQuantity = availableQuantity;
        this.price = price;
        this.image = image;
        this.firstName = firstName;
        this.secondName = secondName;
        this.companyName = companyName;
        this.publisherName = publisherName;
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
        return "BooksAdderModel{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", edition=" + edition +
                ", availableQuantity=" + availableQuantity +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", publisherName='" + publisherName + '\'' +
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
