package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.IAuthorsDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.AuthorsModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorsDAO extends BaseDAO implements IAuthorsDAO {
    private static AuthorsDAO instance;

    private AuthorsDAO () {
        super();
    }

    private List<AuthorsModel> getAuthorsModel (ResultSet resultSet) throws SQLException {
        List<AuthorsModel> authorsModelList = new ArrayList<>();
        while (resultSet.next()) {
            AuthorsModel authorsModel = new AuthorsModel();
            authorsModel.setId(resultSet.getInt("id"));
            authorsModel.setFirstName(resultSet.getString("first_name"));
            authorsModel.setSecondName(resultSet.getString("second_name"));
            authorsModel.setCompanyName(resultSet.getString("company_name"));

            authorsModelList.add(authorsModel);
        }
        return authorsModelList;
    }

    public static AuthorsDAO getInstance() {
        if (instance == null) {
            instance = new AuthorsDAO();
        }
        return instance;
    }

    @Override
    public void insert(AuthorsModel authorsModel) {
        try {
            boolean check = true;
            if (authorsModel.getFirstName() == null && authorsModel.getSecondName() == null &&
                    authorsModel.getCompanyName() == null) {
                check = false;
            } else {
                if (this.selectByAll(authorsModel).size() != 0) {
                    check  = false;
                }
            }
            if (check) {
                String sql = "INSERT INTO AUTHORS (first_name, second_name, company_name) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
                preparedStatement.setString(1, authorsModel.getFirstName());
                preparedStatement.setString(2, authorsModel.getSecondName());
                preparedStatement.setString(3, authorsModel.getCompanyName());

                preparedStatement.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM AUTHORS WHERE id = ?";
            PreparedStatement stmt = this.conn.prepareStatement(query);

            stmt.setInt(1, id);
            stmt.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(AuthorsModel authorsModel) {
        try {
            String sql = "UPDATE AUTHORS SET first_name = ?, second_name = ?, company_name = ? WHERE id = ?";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, authorsModel.getFirstName());
            preparedStatement.setString(2, authorsModel.getSecondName());
            preparedStatement.setString(3, authorsModel.getCompanyName());
            preparedStatement.setString(4, Long.toString(authorsModel.getId()));

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<AuthorsModel> selectByAll(AuthorsModel authorsModel) {
        String conditionFirstName = (authorsModel.getFirstName() != null) ? "first_name = ?" : "first_name IS NULL";
        String conditionSecondName = (authorsModel.getSecondName() != null) ? "second_name = ?" : "second_name IS NULL";
        String conditionCompanyName = (authorsModel.getCompanyName() != null) ? "company_name = ?" : "company_name IS NULL";

        String sql = "SELECT * FROM AUTHORS WHERE " + conditionFirstName + " AND "+ conditionSecondName +" AND " + conditionCompanyName;
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            int temp = 1;
            if (authorsModel.getFirstName() != null) {
                preparedStatement.setString(temp, authorsModel.getFirstName());
                temp = temp + 1;
            }
            if (authorsModel.getSecondName() != null) {
                preparedStatement.setString(temp, authorsModel.getSecondName());
                temp = temp + 1;
            }
            if (authorsModel.getCompanyName() != null) {
                preparedStatement.setString(temp, authorsModel.getCompanyName());
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            return this.getAuthorsModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public AuthorsModel selectById(int id) {
        String sql = "SELECT * FROM AUTHORS WHERE ID = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            return (this.getAuthorsModel(resultSet).size() > 0) ? this.getAuthorsModel(resultSet).get(0) : null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AuthorsModel> selectByFirstName(String firstName) {
        String sql = "SELECT * FROM AUTHORS WHERE FIRST_NAME = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, firstName);

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getAuthorsModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AuthorsModel> selectBySecondName(String secondName) {
        String sql = "SELECT * FROM AUTHORS WHERE SECOND_NAME = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, secondName);

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getAuthorsModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AuthorsModel> selectByCompanyName(String companyName) {
        String sql = "SELECT * FROM AUTHORS WHERE COMPANY_NAME = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, companyName);

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getAuthorsModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AuthorsModel> selectAll() {
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "SELECT * FROM AUTHORS";
            ResultSet resultSet = stmt.executeQuery(sql);

            return this.getAuthorsModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
