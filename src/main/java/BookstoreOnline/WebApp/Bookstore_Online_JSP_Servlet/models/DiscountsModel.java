package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.sql.Timestamp;

public class DiscountsModel {
    private long id;
    private String name;
    private double value;

    public DiscountsModel() {
    }

    public DiscountsModel(long id, String name, double value, Timestamp createDate) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DiscountsModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
