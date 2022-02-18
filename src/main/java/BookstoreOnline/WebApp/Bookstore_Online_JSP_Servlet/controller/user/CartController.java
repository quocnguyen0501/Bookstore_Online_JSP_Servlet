package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.controller.user;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.BooksModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.ItemModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.OrdersModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl.BooksService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartController", value = "/cart")
public class CartController extends HttpServlet {
    private final BooksService booksService = BooksService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (session.getAttribute("user") == null) {
            response.sendRedirect("login");
        } 
        if (action != null && action.equals("delete")) {
            String isbn = request.getParameter("isbn");
            BooksModel bookModel = booksService.selectByIsbn(isbn);
            OrdersModel orderModel = (OrdersModel) session.getAttribute("order");
            List<ItemModel> listItems = orderModel.getItems();
            listItems.removeIf(itemModel -> itemModel.getBookModel().getIsbn().equals(bookModel.getIsbn()));
            session.setAttribute("order", orderModel);
        }
        if (action != null && action.equals("update")) {
            String isbn;
            if (request.getParameter("isbn") != null) {
                isbn = request.getParameter("isbn");
                BooksModel booksModel = booksService.selectByIsbn(isbn);
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                OrdersModel orderModel = (OrdersModel) session.getAttribute("order");
                List<ItemModel> listItems = orderModel.getItems();
                for (ItemModel itemModel : listItems) {
                    if (itemModel.getBookModel().getIsbn().equals(booksModel.getIsbn())) {
                        itemModel.setQuantity(quantity);
                    }
                }
                session.setAttribute("order", orderModel);
            }
        }
        request.getRequestDispatcher("/views/user/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            response.sendRedirect("login");
        } else {
                int quantity = 1;
                String isbn;
                if (request.getParameter("isbn") != null) {
                    isbn = request.getParameter("isbn");
                    BooksModel booksModel = booksService.selectByIsbn(isbn);
                    if (booksModel != null) {
                        if (request.getParameter("quantity") != null) {
                            quantity = Integer.parseInt(request.getParameter("quantity"));
                        }
                        if (session.getAttribute("order") == null) {
                            OrdersModel orderModel = new OrdersModel();
                            List<ItemModel> listItems = new ArrayList<>();
                            ItemModel itemModel = new ItemModel();
                            itemModel.setQuantity(quantity);
                            itemModel.setBookModel(booksModel);
                            listItems.add(itemModel);
                            orderModel.setItems(listItems);
                            session.setAttribute("order", orderModel);
                        } else {
                            OrdersModel orderModel = (OrdersModel) session.getAttribute("order");
                            List<ItemModel> listItems = orderModel.getItems();
                            boolean check = false;
                            for (ItemModel itemModel : listItems) {
                                if (itemModel.getBookModel().getIsbn().equals(booksModel.getIsbn())) {
                                    itemModel.setQuantity(itemModel.getQuantity() + quantity);
                                    check = true;
                                }
                            }
                            if (!check) {
                                ItemModel itemModel = new ItemModel();
                                itemModel.setQuantity(quantity);
                                itemModel.setBookModel(booksModel);
                                listItems.add(itemModel);
                            }
                            session.setAttribute("order", orderModel);
                        }
                    }
                }
            request.getRequestDispatcher("/views/user/cart.jsp").forward(request, response);
        }
    }
}
