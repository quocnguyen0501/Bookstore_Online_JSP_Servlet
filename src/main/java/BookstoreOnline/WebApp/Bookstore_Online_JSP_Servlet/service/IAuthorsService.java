package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.AuthorsModel;

import java.util.List;

public interface IAuthorsService {
    public void insert (AuthorsModel authorsModel);
    public void delete (int id);
    public void update (AuthorsModel authorsModel);

    public List<AuthorsModel> selectByAll (AuthorsModel authorsModel);
    public AuthorsModel selectById (int id);
    public List<AuthorsModel> selectByFirstName (String firstName);
    public List<AuthorsModel> selectBySecondName (String secondName);
    public List<AuthorsModel> selectByCompanyName (String companyName);
    public List<AuthorsModel> selectAll ();
}
