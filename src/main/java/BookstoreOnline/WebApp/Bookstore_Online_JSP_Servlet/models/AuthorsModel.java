package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.sql.Timestamp;

public class AuthorsModel {
    private int id;
    private String firstName;
    private String secondName;
    private String companyName;

    public AuthorsModel() {
    }

    public AuthorsModel(int id, String firstName, String secondName, String companyName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AuthorsModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
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
}
