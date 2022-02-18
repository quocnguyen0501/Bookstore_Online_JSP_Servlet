package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models;

import java.sql.Timestamp;

public class UserModel {
    private long id;
    private String username;
    private String password;
    private String fullName;
    private String imageProfile;

    public UserModel() {
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public UserModel(long id, String username, String password, String fullName,
                     String imageProfile) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.imageProfile = imageProfile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", imageProfile='" + imageProfile + '\'' +
                '}';
    }
}
