package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.GenresModel;

import java.util.List;

public interface IGenresService {
    public void insert (GenresModel genresModel);
    public void delete (int id);
    public void update (GenresModel genresModel);

    public List<GenresModel> selectByAll (GenresModel genresModel);
    public List<GenresModel> selectAll ();

    public List<Integer> listTotalBooksGenres (List<GenresModel> genresModelList);

    public List<String> selectByIsbn (String isbn);
}
