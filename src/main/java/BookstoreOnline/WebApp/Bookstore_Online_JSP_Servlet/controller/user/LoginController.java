package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.controller.user;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.UserModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IUserService;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class LoginController extends HttpServlet {
    private static final IUserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userService.isExist(username, password)) {
            HttpSession session = request.getSession();
            UserModel userModel = userService.selectByUsernameAndPassword(username, password).get(0);

            session.setAttribute("user", userModel.getFullName());
            session.setAttribute("role", userService.getRole(userModel.getId()));

            response.sendRedirect(request.getContextPath() + "/home-page");
        } else {
            request.setAttribute("error", "Username or Password was invalid! Please try again!");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
    }
}
