package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.AuthorsModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.BooksModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.GenresModel;

import java.util.List;

public interface IGenresDAO extends IBaseDAO{
    public void insert (GenresModel genresModel);
    public void delete (int id);
    public void update (GenresModel genresModel);

    public List<GenresModel> selectByAll (GenresModel genresModel);
    public List<GenresModel> selectAll ();
    public List<String> selectByIsbn (String isbn);
}
