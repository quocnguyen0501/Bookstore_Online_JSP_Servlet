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
import java.util.List;

@WebServlet(name = "ServletBookDetailController", value = "/book-detail")
public class BookDetailController extends HttpServlet {
    private static final IBooksService bookService = BooksService.getInstance();
    private static final IGenresService genresService = GenresService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page-name", "Book Detail");
        String isbn = request.getParameter("isbn");
        if (isbn != null) {
            BooksModel booksModel = bookService.selectByIsbn(isbn);
            List<String> genres = genresService.selectByIsbn(booksModel.getIsbn());
            List<BooksModel> similarBooks = bookService.getSimilarBooks(booksModel, genres);

            request.setAttribute("booksModel", booksModel);
            request.setAttribute("genres", genres);
            request.setAttribute("similarBooks", similarBooks);

            request.getRequestDispatcher("/views/user/single_book.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
