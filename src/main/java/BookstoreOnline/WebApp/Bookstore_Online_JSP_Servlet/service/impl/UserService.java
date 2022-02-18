package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl.UserDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.UserModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private final UserDAO userDAO;

    private static UserService instance;

    private UserService () {
        userDAO = UserDAO.getInstance();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    @Override
    public void insert(UserModel userModel) {
        userDAO.insert(userModel);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public void update(UserModel userModel) {
        userDAO.update(userModel);
    }

    @Override
    public void changePassword(long id, String password) {
        userDAO.changePassword(id, password);
    }

    @Override
    public List<UserModel> selectByAll(UserModel userModel) {
        return userDAO.selectByAll(userModel);
    }

    @Override
    public UserModel selectById(int id) {
        return userDAO.selectById(id);
    }

    @Override
    public List<UserModel> selectByName(String name) {
        return userDAO.selectByName(name);
    }

    @Override
    public List<UserModel> selectAll() {
        return userDAO.selectAll();
    }

    @Override
    public List<UserModel> selectByUsernameAndPassword(String username, String password) {
        return userDAO.selectByUsernameAndPassword(username, password);
    }

    @Override
    public List<UserModel> selectByUsername(String username) {
        return userDAO.selectByUsername(username);
    }

    @Override
    public boolean isSignup(String username) {
        return this.selectByUsername(username).size() > 0;
    }

    @Override
    public boolean isExist(String username, String password) {
        return this.selectByUsernameAndPassword(username, password).size() > 0;
    }

    @Override
    public List<Integer> getRole(long userId) {
        return userDAO.getRole(userId);
    }
}
