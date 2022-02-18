package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.RoleModel;

import java.util.List;

public interface IRoleService {
    public List<RoleModel> selectAll ();
}
