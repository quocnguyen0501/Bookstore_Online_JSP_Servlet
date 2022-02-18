package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl.PublishersDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl.RoleDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.RoleModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.service.IRoleService;

import java.util.List;

public class RoleService implements IRoleService {
    private final RoleDAO roleDAO;

    private static RoleService instance;

    private RoleService () {
        roleDAO = RoleDAO.getInstance();
    }

    public static RoleService getInstance() {
        if (instance == null) {
            instance = new RoleService();
        }
        return instance;
    }
    @Override
    public List<RoleModel> selectAll() {
        return roleDAO.selectAll();
    }
}
