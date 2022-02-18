package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.sql.Timestamp;

public class PublishersModel {
    private int id;
    private String name;

    public PublishersModel() {
    }

    public PublishersModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PublishersModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
