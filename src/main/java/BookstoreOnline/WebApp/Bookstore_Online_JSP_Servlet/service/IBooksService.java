package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.BooksAdderModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.BooksModel;

import java.util.List;

public interface IBooksService {
    public void insert (BooksAdderModel booksAdderModel);
    public void delete (String isbn);
    public void update (BooksModel booksModel);
    public void changeImage (String isbn, String urlImage);

    public BooksModel selectByIsbn (String isbn);

    public List<BooksModel> selectByAll (BooksModel booksModel);
    public List<BooksModel> selectByAuthor (String name);
    public List<BooksModel> selectByTitle (String title);
    public List<BooksModel> selectAll ();
    public List<BooksModel> selectByGenres (int genresId);
    public List<BooksModel> selectTop10BooksLatest ();
    public List<BooksModel> getPaging (int index, int genresId);
    public List<BooksModel> getSimilarBooks (BooksModel booksModel, List<String> genres);

    public int getTotalsBooks (int genresId);
    public int getTotalPages (int genresId);
}
