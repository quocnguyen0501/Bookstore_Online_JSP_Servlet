package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.RoleModel;

import java.util.List;

public interface IRoleDAO extends IBaseDAO{
    public List<RoleModel> selectAll ();
}
