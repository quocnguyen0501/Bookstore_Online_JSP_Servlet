package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.helper;

import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp.datasources.SharedPoolDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DatabaseHelper {
    private static DatabaseHelper instance;

    private DatabaseHelper() {}

    public static DatabaseHelper getInstance() {
        if (instance == null) {
            instance = new DatabaseHelper();
        }
        return instance;
    }

    private DataSource getDataSource() throws ClassNotFoundException {
        DataSource ds;

        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:/Users/nguyennguyen/Dev/Java/Bookstore_Online_JSP_Servlet/src/main/resources/database/BookstoreOnline";

        final String USER = "sa";
        final String PASS = "";

        DriverAdapterCPDS driver = new DriverAdapterCPDS();

        driver.setDriver(JDBC_DRIVER);
        driver.setUrl(DB_URL);
        driver.setUser(USER);
        driver.setPassword(PASS);

        SharedPoolDataSource sharedPoolDS = new SharedPoolDataSource();
        sharedPoolDS.setConnectionPoolDataSource(driver);
        sharedPoolDS.setMaxActive(10);
        sharedPoolDS.setMaxWait(50);

        ds = sharedPoolDS;

        return ds;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        DataSource ds = getDataSource();

        return ds.getConnection();
    }
}
