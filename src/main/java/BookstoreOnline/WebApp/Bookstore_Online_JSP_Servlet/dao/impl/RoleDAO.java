package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.IRoleDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.RoleModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends BaseDAO implements IRoleDAO {
    private static RoleDAO instance;

    private RoleDAO () {
        super();
    }

    public static RoleDAO getInstance() {
        if (instance == null) {
            instance = new RoleDAO();
        }
        return instance;
    }

    private List<RoleModel> getRoleModel (ResultSet resultSet) throws SQLException {
        List<RoleModel> roleModelsList = new ArrayList<>();

        while (resultSet.next()) {
            RoleModel roleModel = new RoleModel();

            roleModel.setId(resultSet.getInt("id"));
            roleModel.setName(resultSet.getString("name"));

            roleModelsList.add(roleModel);
        }

        return roleModelsList;
    }

    @Override
    public List<RoleModel> selectAll() {
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "SELECT * FROM ROLE";
            ResultSet resultSet = stmt.executeQuery(sql);

            return this.getRoleModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
