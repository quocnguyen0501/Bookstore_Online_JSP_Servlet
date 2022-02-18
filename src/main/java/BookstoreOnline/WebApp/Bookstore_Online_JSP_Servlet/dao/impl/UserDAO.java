package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.IUserDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends BaseDAO implements IUserDAO {
    private static UserDAO instance;

    private UserDAO () {
        super();
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    private List<UserModel> getUsersModel (ResultSet resultSet) throws SQLException {
        List<UserModel> userModelList = new ArrayList<>();

        while (resultSet.next()) {
            UserModel userModel = new UserModel();

            userModel.setId(resultSet.getLong("id"));
            userModel.setUsername(resultSet.getString("username"));
            userModel.setPassword(resultSet.getString("password"));
            userModel.setFullName(resultSet.getString("full_name"));
            userModel.setImageProfile(resultSet.getString("avatar"));

           userModelList.add(userModel);
        }

        return userModelList;
    }

    @Override
    public void insert(UserModel userModel) {
        if (userModel.getUsername() != null &&
                userModel.getPassword() != null &&
                userModel.getFullName() != null &&
                this.selectByAll(userModel).size() == 0) {
            String sql = "INSERT INTO USERS (USERNAME, PASSWORD, FULL_NAME) VALUES (?, ?, ?)";
            try {
                PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

                preparedStatement.setString(1, userModel.getUsername());
                preparedStatement.setString(2, userModel.getPassword());
                preparedStatement.setString(3, userModel.getFullName());

                preparedStatement.execute();

                UserModel user = this.selectByUsernameAndPassword(userModel.getUsername(), userModel.getPassword()).get(0);

                String secSql = "INSERT INTO user_role (USER_ID, ROLE_ID) VALUES (?, 2)";
                preparedStatement = this.conn.prepareStatement(secSql);

                preparedStatement.setLong(1, user.getId());

                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM USERS WHERE ID = ?";
            PreparedStatement stmt = this.conn.prepareStatement(query);

            stmt.setInt(1, id);
            stmt.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(UserModel userModel) {
        String sql = "UPDATE USERS SET USERNAME = ?, PASSWORD = ?, FULL_NAME = ?";
        if (userModel.getImageProfile() != null) {
            sql  = sql + ", AVATAR = ?";
        }
        sql = sql + "WHERE ID = ?";
        try {

            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, userModel.getUsername());
            preparedStatement.setString(2, userModel.getPassword());
            preparedStatement.setString(3, userModel.getFullName());
            int i = 4;
            if (userModel.getImageProfile() != null) {
                preparedStatement.setString(i, userModel.getImageProfile());
            }
            preparedStatement.setLong(i, userModel.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void changePassword(long id, String password) {
        String sql = "UPDATE USERS SET FULL_NAME = ? WHERE ID = ?";
        try {

            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, password);
            preparedStatement.setLong(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<UserModel> selectByAll(UserModel userModel) {
        String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND FULL_NAME = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, userModel.getUsername());
            preparedStatement.setString(2, userModel.getFullName());

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getUsersModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public UserModel selectById(int id) {
        String sql = "SELECT * FROM USERS WHERE ID = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            return (this.getUsersModel(resultSet).size() > 0) ? this.getUsersModel(resultSet).get(0) : null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserModel> selectByName(String name) {
        String sql = "SELECT * FROM USERS WHERE FULL_NAME LIKE ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getUsersModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserModel> selectAll() {
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "SELECT * FROM USERS";
            ResultSet resultSet = stmt.executeQuery(sql);

            return this.getUsersModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserModel> selectByUsernameAndPassword(String username, String password) {
        try {
            String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getUsersModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserModel> selectByUsername(String username) {
        try {
            String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getUsersModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Integer> getRole(long userId) {
        try {
            String sql = "SELECT ROLE_ID FROM USER_ROLE " +
                    "INNER JOIN ROLE R on R.ID = USER_ROLE.ROLE_ID " +
                    "INNER JOIN USERS U on U.ID = USER_ROLE.USER_ID " +
                    "WHERE U.ID = ?;";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setLong(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Integer> listRole = new ArrayList<>();
            while (resultSet.next()) {
                listRole.add(resultSet.getInt("role_id"));
            }

            return listRole;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
