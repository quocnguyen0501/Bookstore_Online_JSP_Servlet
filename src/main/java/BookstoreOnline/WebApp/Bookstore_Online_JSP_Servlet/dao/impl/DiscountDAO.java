package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.IDiscountDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.DiscountsModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiscountDAO extends BaseDAO implements IDiscountDAO {
    private static DiscountDAO instance;

    private DiscountDAO () {
        super();
    }

    public static DiscountDAO getInstance() {
        if (instance == null) {
            instance = new DiscountDAO();
        }
        return instance;
    }

    private List<DiscountsModel> getDiscountModel (ResultSet resultSet) throws SQLException {
        List<DiscountsModel> discountsModelsList = new ArrayList<>();

        while (resultSet.next()) {
            DiscountsModel discountsModel = new DiscountsModel();

            discountsModel.setId(resultSet.getInt("id"));
            discountsModel.setName(resultSet.getString("name"));
            discountsModel.setValue(resultSet.getDouble("value"));

            discountsModelsList.add(discountsModel);
        }

        return discountsModelsList;
    }

    @Override
    public void insert(DiscountsModel discountsModel) {
        if (this.selectByAll(discountsModel).size() == 0) {
            String sql = "INSERT INTO DISCOUNTS (NAME, VALUE) VALUES (?, ?)";
            try {
                PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

                preparedStatement.setString(1, discountsModel.getName());
                preparedStatement.setDouble(2, discountsModel.getValue());

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
    public void update(DiscountsModel discountsModel) {
        try {
            String sql = "UPDATE DISCOUNTS SET NAME = ?, VALUE = ? WHERE ID = ?";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, discountsModel.getName());
            preparedStatement.setDouble(2, discountsModel.getValue());
            preparedStatement.setLong(3,discountsModel.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<DiscountsModel> selectByAll(DiscountsModel discountsModel) {
        String sql = "SELECT * FROM DISCOUNTS WHERE NAME = ? AND VALUE = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, discountsModel.getName());
            preparedStatement.setDouble(2, discountsModel.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getDiscountModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public DiscountsModel selectById(int id) {
        String sql = "SELECT * FROM DISCOUNTS WHERE ID = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            return (this.getDiscountModel(resultSet).size() > 0) ? this.getDiscountModel(resultSet).get(0) : null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DiscountsModel> selectByName(String name) {
        String sql = "SELECT * FROM DISCOUNTS WHERE NAME LIKE ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, "%" + name + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getDiscountModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DiscountsModel> selectByValue(Double value) {
        String sql = "SELECT * FROM DISCOUNTS WHERE VALUE = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setDouble(1, value);

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getDiscountModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DiscountsModel> selectAll() {
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "SELECT * FROM DISCOUNTS";
            ResultSet resultSet = stmt.executeQuery(sql);

            return this.getDiscountModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
