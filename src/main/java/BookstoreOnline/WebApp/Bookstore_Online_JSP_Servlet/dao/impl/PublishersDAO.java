package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.IPublishersDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.PublishersModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PublishersDAO extends BaseDAO implements IPublishersDAO {
    private static PublishersDAO instance;

    private PublishersDAO () {
        super();
    }

    public static PublishersDAO getInstance() {
        if (instance == null) {
            instance = new PublishersDAO();
        }
        return instance;
    }

    private List<PublishersModel> getPublishersModel (ResultSet resultSet) throws SQLException {
        List<PublishersModel> publishersModelList = new ArrayList<>();

        while (resultSet.next()) {
            PublishersModel publishersModel = new PublishersModel();

            publishersModel.setId(resultSet.getInt("id"));
            publishersModel.setName(resultSet.getString("name"));

            publishersModelList.add(publishersModel);
        }

        return publishersModelList;
    }

    @Override
    public void insert(PublishersModel publishersModel) {
        if (publishersModel.getName() != null && this.selectByAll(publishersModel).size() == 0) {
            String sql = "INSERT INTO PUBLISHERS (NAME) VALUES (?)";
            try {
                PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

                preparedStatement.setString(1, publishersModel.getName());

                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM PUBLISHERS WHERE ID = ?";
            PreparedStatement stmt = this.conn.prepareStatement(query);

            stmt.setInt(1, id);
            stmt.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(PublishersModel publishersModel) {
        try {
            String sql = "UPDATE PUBLISHERS SET NAME = ? WHERE ID = ?";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, publishersModel.getName());
            preparedStatement.setInt(2, publishersModel.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<PublishersModel> selectByAll(PublishersModel publishersModel) {
        String sql = "SELECT * FROM PUBLISHERS WHERE NAME = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, publishersModel.getName());

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getPublishersModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public PublishersModel selectById(int id) {
        String sql = "SELECT * FROM PUBLISHERS WHERE ID = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            return (this.getPublishersModel(resultSet).size() > 0) ? this.getPublishersModel(resultSet).get(0) : null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PublishersModel> selectByName(String name) {
        String sql = "SELECT * FROM PUBLISHERS WHERE NAME = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getPublishersModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PublishersModel> selectAll() {
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "SELECT * FROM PUBLISHERS";
            ResultSet resultSet = stmt.executeQuery(sql);

            return this.getPublishersModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
