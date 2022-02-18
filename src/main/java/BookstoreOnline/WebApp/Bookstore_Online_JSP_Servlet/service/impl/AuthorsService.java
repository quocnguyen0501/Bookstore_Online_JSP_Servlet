package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl.AuthorsDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.AuthorsModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IAuthorsService;

import java.util.List;

public class AuthorsService implements IAuthorsService {
    private final AuthorsDAO authorsDAO;
    private static AuthorsService instance;

    private AuthorsService () {
        authorsDAO = AuthorsDAO.getInstance();
    }

    public static AuthorsService getInstance() {
        if (instance == null) {
            instance = new AuthorsService();
        }
        return instance;
    }

    @Override
    public void insert(AuthorsModel authorsModel) {
        authorsDAO.insert(authorsModel);
    }

    @Override
    public void delete(int id) {
        authorsDAO.delete(id);
    }

    @Override
    public void update(AuthorsModel authorsModel) {
        authorsDAO.update(authorsModel);
    }

    @Override
    public List<AuthorsModel> selectByAll(AuthorsModel authorsModel) {
        return authorsDAO.selectByAll(authorsModel);
    }

    @Override
    public AuthorsModel selectById(int id) {
        return authorsDAO.selectById(id);
    }

    @Override
    public List<AuthorsModel> selectByFirstName(String firstName) {
        return authorsDAO.selectByFirstName(firstName);
    }

    @Override
    public List<AuthorsModel> selectBySecondName(String secondName) {
        return authorsDAO.selectBySecondName(secondName);
    }

    @Override
    public List<AuthorsModel> selectByCompanyName(String companyName) {
        return authorsDAO.selectByCompanyName(companyName);
    }

    @Override
    public List<AuthorsModel> selectAll() {
        return authorsDAO.selectAll();
    }
}
