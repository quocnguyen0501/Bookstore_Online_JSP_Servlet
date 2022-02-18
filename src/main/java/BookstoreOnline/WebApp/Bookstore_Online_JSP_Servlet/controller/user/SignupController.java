package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.controller.user;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.UserModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IUserService;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletSignup", value = "/signup")
public class SignupController extends HttpServlet {
    private static final IUserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("full_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("re_password");
        String ans = request.getParameter("agree-term");

        System.out.println(fullName + "|" + username + "|" + password + "|" + rePassword + "|" + ans);

        if (ans == null) {
            request.setAttribute("username", username);
            request.setAttribute("full_name", fullName);

            request.setAttribute("error", "Please check in check box for agree!");
            request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
        } else {
            if (!password.equals(rePassword)) {
                request.setAttribute("username", username);
                request.setAttribute("full_name", fullName);

                request.setAttribute("error", "Please check password and re-password again!");
                request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
            } else {
                if (userService.isSignup(username)) {
                    request.setAttribute("username", username);
                    request.setAttribute("full_name", fullName);

                    request.setAttribute("error", "Your username was registered!");
                    request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
                } else {
                    UserModel userModel = new UserModel();

                    userModel.setFullName(fullName);
                    userModel.setUsername(username);
                    userModel.setPassword(password);

                    userService.insert(userModel);

                    if (userService.isExist(username, password)) {
                        response.sendRedirect(request.getContextPath() + "/login");
                    } else {
                        request.setAttribute("username", username);
                        request.setAttribute("full_name", fullName);

                        request.setAttribute("error", "Something went wrong! Please try again!");
                        request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
                    }
                }
            }
        }
    }
}
