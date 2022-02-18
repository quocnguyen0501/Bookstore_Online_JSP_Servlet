package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl.DiscountDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl.GenresDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.GenresModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IGenresService;

import java.util.ArrayList;
import java.util.List;

public class GenresService implements IGenresService {
    private final GenresDAO genresDAO;

    private static GenresService instance;

    private GenresService () {
        genresDAO = GenresDAO.getInstance();
    }

    public static GenresService getInstance() {
        if (instance == null) {
            instance = new GenresService();
        }
        return instance;
    }

    @Override
    public void insert(GenresModel genresModel) {
        genresDAO.insert(genresModel);
    }

    @Override
    public void delete(int id) {
        genresDAO.delete(id);
    }

    @Override
    public void update(GenresModel genresModel) {
        genresDAO.update(genresModel);
    }

    @Override
    public List<GenresModel> selectByAll(GenresModel genresModel) {
        return genresDAO.selectByAll(genresModel);
    }

    @Override
    public List<GenresModel> selectAll() {
        return genresDAO.selectAll();
    }

    @Override
    public List<Integer> listTotalBooksGenres(List<GenresModel> genresModelList) {
        BooksService booksService = BooksService.getInstance();
        List<Integer> listTotalBooksGenres = new ArrayList<>();
        for (GenresModel genresModel : genresModelList) {
            int quantity = booksService.getTotalsBooks(genresModel.getId());
            listTotalBooksGenres.add(quantity);
        }
        return listTotalBooksGenres;
    }

    @Override
    public List<String> selectByIsbn(String isbn) {
        return genresDAO.selectByIsbn(isbn);
    }
}
