package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.controller.user;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.BooksModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.GenresModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IBooksService;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IGenresService;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl.BooksService;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl.GenresService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletBooksController", value = "/books")
public class BooksController extends HttpServlet {
    private static final IBooksService bookService = BooksService.getInstance();
    private static final IGenresService genresService = GenresService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GenresModel> genresModelList = genresService.selectAll();
        List<Integer> totalBooksGenres = genresService.listTotalBooksGenres(genresModelList);
        List<BooksModel> booksModelList = bookService.selectAll();

        int totalBooks = bookService.getTotalsBooks(0);
        int totalPages = bookService.getTotalPages(0);

        request.setAttribute("genresModelList", genresModelList);
        request.setAttribute("totalBooksGenres", totalBooksGenres);
        request.setAttribute("totalBooks", totalBooks);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("allBooks", booksModelList);

        request.getRequestDispatcher("/views/user/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
