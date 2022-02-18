package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

public class GenresModel {
    private int id;
    private String name;

    public GenresModel() {
    }

    public GenresModel(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "GenresModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
