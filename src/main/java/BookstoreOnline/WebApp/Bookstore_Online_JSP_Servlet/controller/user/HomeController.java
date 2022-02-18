package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.controller.user;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl.AuthorsDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl.BooksDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.helper.DatabaseHelper;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.BooksModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.GenresModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IBooksService;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IGenresService;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl.BooksService;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl.GenresService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/home-page"})
public class HomeController extends HttpServlet {
    private static final IGenresService genresService = GenresService.getInstance();
    private static final IBooksService booksService = BooksService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page-name", "Home");
        List<GenresModel>genresModelList = genresService.selectAll();
        List<BooksModel> top10BooksLatest = booksService.selectTop10BooksLatest();

        request.setAttribute("genresModelList", genresModelList);
        request.setAttribute("top10BookLatest", top10BooksLatest);

        String action  = request.getParameter("action");
        if (action != null && action.equals("cart")) {
            request.getRequestDispatcher("/views/user/book-genres.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/views/user/home.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
