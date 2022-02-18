package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.IBaseDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.helper.DatabaseHelper;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseDAO implements IBaseDAO {
    protected Connection conn;

    public BaseDAO () {
        this.conn = this.getConnection();
    }

    @Override
    public Connection getConnection() {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();

        Connection conn = null;

        try {
            conn = databaseHelper.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
