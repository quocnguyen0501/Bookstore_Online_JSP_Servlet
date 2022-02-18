package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.controller.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogout", value = "/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page-name", "Home");
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("role");
        response.sendRedirect(request.getContextPath() + "/home-page");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
