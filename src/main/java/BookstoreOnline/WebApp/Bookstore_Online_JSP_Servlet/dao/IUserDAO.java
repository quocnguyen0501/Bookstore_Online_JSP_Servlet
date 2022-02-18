package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.PublishersModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.UserModel;

import java.util.List;

public interface IUserDAO extends IBaseDAO{
    public void insert (UserModel userModel);
    public void delete (int id);
    public void update (UserModel userModel);
    public void changePassword (long id, String password);

    public List<UserModel> selectByAll (UserModel userModel);
    public UserModel selectById (int id);
    public List<UserModel> selectByName (String name);
    public List<UserModel> selectAll ();
    public List<UserModel> selectByUsernameAndPassword (String username, String password);
    public List<UserModel> selectByUsername (String username);
    public List<Integer> getRole (long userId);
}
