package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.IGenresDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.GenresModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenresDAO extends BaseDAO implements IGenresDAO {
    private static GenresDAO instance;

    private GenresDAO () {
        super();
    }

    public static GenresDAO getInstance() {
        if (instance == null) {
            instance = new GenresDAO();
        }
        return instance;
    }

    private List<GenresModel> getGenresModel (ResultSet resultSet) throws SQLException {
        List<GenresModel> genresModelList = new ArrayList<>();

        while (resultSet.next()) {
            GenresModel genresModel = new GenresModel();

            genresModel.setId(resultSet.getInt("id"));
            genresModel.setName(resultSet.getString("name"));

            genresModelList.add(genresModel);
        }

        return genresModelList;
    }

    @Override
    public void insert(GenresModel genresModel) {
        if (genresModel.getName() != null && this.selectByAll(genresModel).size() == 0) {
            String sql = "INSERT INTO GENRES (NAME) VALUES (?)";
            try {
                PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

                preparedStatement.setString(1, genresModel.getName());

                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM GENRES WHERE ID = ?";
            PreparedStatement stmt = this.conn.prepareStatement(query);

            stmt.setInt(1, id);
            stmt.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(GenresModel genresModel) {
        try {
            String sql = "UPDATE GENRES SET NAME = ? WHERE ID = ?";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, genresModel.getName());
            preparedStatement.setInt(2, (int) genresModel.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<GenresModel> selectByAll(GenresModel genresModel) {
        String sql = "SELECT * FROM PUBLISHERS WHERE NAME = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, genresModel.getName());

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getGenresModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<GenresModel> selectAll() {
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "SELECT * FROM GENRES";
            ResultSet resultSet = stmt.executeQuery(sql);

            return this.getGenresModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> selectByIsbn(String isbn) {
        String sql = "SELECT NAME FROM GENRES\n" +
                "INNER JOIN BOOKS_GENRES BG on GENRES.ID = BG.GENRE_ID\n" +
                "INNER JOIN BOOKS B on BG.BOOK_ISBN = B.ISBN\n" +
                "WHERE ISBN = ?;";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, isbn);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<String> genresList = new ArrayList<>();

            while (resultSet.next()) {
                genresList.add(resultSet.getString("NAME"));
            }

            return genresList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
