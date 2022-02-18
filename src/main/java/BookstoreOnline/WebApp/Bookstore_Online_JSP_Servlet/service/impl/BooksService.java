package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl.BooksDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.BooksAdderModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.BooksModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IBooksService;

import java.util.List;

public class BooksService implements IBooksService {
    private final BooksDAO booksDAO;

    private static BooksService instance;

    private BooksService () {
        booksDAO = BooksDAO.getInstance();
    }

    public static BooksService getInstance() {
        if (instance == null) {
            instance = new BooksService();
        }
        return instance;
    }

    @Override
    public void insert(BooksAdderModel booksAdderModel) {
        booksDAO.insert(booksAdderModel);
    }

    @Override
    public void delete(String isbn) {
        booksDAO.delete(isbn);
    }

    @Override
    public void update(BooksModel booksModel) {
        booksDAO.update(booksModel);
    }

    @Override
    public void changeImage(String isbn, String urlImage) {
        booksDAO.changeImage(isbn, urlImage);
    }

    @Override
    public BooksModel selectByIsbn(String isbn) {
        return booksDAO.selectByIsbn(isbn);
    }

    @Override
    public List<BooksModel> selectByAll(BooksModel booksModel) {
        return booksDAO.selectByAll(booksModel);
    }

    @Override
    public List<BooksModel> selectByAuthor(String name) {
        return booksDAO.selectByAuthor(name);
    }

    @Override
    public List<BooksModel> selectByTitle(String title) {
        return booksDAO.selectByTitle(title);
    }

    @Override
    public List<BooksModel> selectAll() {
        return booksDAO.selectAll();
    }

    @Override
    public List<BooksModel> selectByGenres(int genresId) {
        return booksDAO.selectByGenres(genresId);
    }

    @Override
    public List<BooksModel> selectTop10BooksLatest() {
        return booksDAO.selectTop10BooksLatest();
    }

    @Override
    public List<BooksModel> getPaging(int index, int genresId) {
        return booksDAO.getPaging(index, genresId);
    }

    @Override
    public List<BooksModel> getSimilarBooks(BooksModel booksModel, List<String> genres) {
        return booksDAO.getSimilarBooks(booksModel, genres);
    }

    @Override
    public int getTotalsBooks(int genresId) {
        return booksDAO.getTotalsBooks(genresId);
    }

    @Override
    public int getTotalPages(int genresId) {
        int totalPages = this.getTotalsBooks(genresId) / 12;
        return (totalPages % 12 != 0) ? (totalPages + 1) : (totalPages) ;
    }
}
