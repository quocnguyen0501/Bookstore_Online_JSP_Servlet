package BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.impl;

import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.dao.IBookDAO;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.AuthorsModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.BooksAdderModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.BooksModel;
import BookstoreOnline.WebApp.Bookstore_Online_JSP_Servlet.models.PublishersModel;

import java.awt.print.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksDAO extends BaseDAO implements IBookDAO {
    private static BooksDAO instance;

    private BooksDAO () {
        super();
    }

    public static BooksDAO getInstance() {
        if (instance == null) {
            instance = new BooksDAO();
        }
        return instance;
    }

    private List<BooksModel> getBooksModel (ResultSet resultSet) throws SQLException {
        List<BooksModel> booksModelList = new ArrayList<>();
        while (resultSet.next()) {
            BooksModel booksModel = new BooksModel();

            booksModel.setIsbn(resultSet.getString("isbn"));
            booksModel.setTitle(resultSet.getString("title"));
            booksModel.setPublicationDate(resultSet.getDate("publication_date"));
            booksModel.setEdition(resultSet.getInt("edition"));
            booksModel.setAvailableQuantity(resultSet.getInt("available_quantity"));
            booksModel.setPrice(resultSet.getDouble("price"));
            booksModel.setAuthorId(resultSet.getLong("author"));
            booksModel.setPublisherId(resultSet.getLong("publisher"));
            booksModel.setImage(resultSet.getString("images"));

            booksModelList.add(booksModel);
        }
        return booksModelList;
    }

    @Override
    public void insert(BooksAdderModel booksAdderModel) {
        AuthorsDAO authorsDAO = AuthorsDAO.getInstance();
        PublishersDAO publishersDAO = PublishersDAO.getInstance();

        AuthorsModel authorsModel = new AuthorsModel();
        authorsModel.setFirstName(booksAdderModel.getFirstName());
        authorsModel.setSecondName(booksAdderModel.getSecondName());
        authorsModel.setCompanyName(booksAdderModel.getCompanyName());

        PublishersModel publishersModel = new PublishersModel();
        publishersModel.setName(booksAdderModel.getPublisherName());

        if (this.selectByIsbn(booksAdderModel.getIsbn()) == null) {
            if (authorsDAO.selectByAll(authorsModel).isEmpty()) {
                authorsDAO.insert(authorsModel);
            }
            if (publishersDAO.selectByAll(publishersModel).isEmpty()) {
                publishersDAO.insert(publishersModel);
            }
        }

        System.out.println(authorsDAO.selectByAll(authorsModel).get(0).getId());
        System.out.println(publishersDAO.selectByAll(publishersModel).get(0).getId());
        BooksModel booksModel = new BooksModel(booksAdderModel.getIsbn(), booksAdderModel.getTitle(),
                booksAdderModel.getPublicationDate(), booksAdderModel.getEdition(), booksAdderModel.getAvailableQuantity(),
                booksAdderModel.getPrice(), authorsDAO.selectByAll(authorsModel).get(0).getId(),
                publishersDAO.selectByAll(publishersModel).get(0).getId(), booksAdderModel.getImage());
        String sql = "INSERT INTO books (isbn, title, publication_date, edition, available_quantity, price, author, " +
                "publisher, images) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
            preparedStatement.setString(1, booksModel.getIsbn());
            preparedStatement.setString(2, booksModel.getTitle());
            preparedStatement.setDate(3, booksModel.getPublicationDate());
            preparedStatement.setInt(4, booksModel.getEdition());
            preparedStatement.setInt(5, booksModel.getAvailableQuantity());
            preparedStatement.setDouble(6, booksModel.getPrice());
            preparedStatement.setLong(7, booksModel.getAuthorId());
            preparedStatement.setLong(8, booksModel.getPublisherId());
            preparedStatement.setString(9, booksModel.getImage());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(String isbn) {
        try {
            String query = "DELETE FROM BOOKS WHERE isbn = ?";
            PreparedStatement stmt = this.conn.prepareStatement(query);

            stmt.setString(1, isbn);
            stmt.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(BooksModel booksModel) {
        try {
            String sql = "UPDATE books SET " +
                    "isbn = ?, " +
                    "title = ?, " +
                    "publication_date = ?, " +
                    "edition = ?, " +
                    "available_quantity = ?," +
                    "price = ?, " +
                    "author = ?, " +
                    "publisher = ?, " +
                    "images = ? " +
                    "WHERE isbn = ?";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, booksModel.getIsbn());
            preparedStatement.setString(2, booksModel.getTitle());
            preparedStatement.setDate(3, booksModel.getPublicationDate());
            preparedStatement.setInt(4, booksModel.getEdition());
            preparedStatement.setInt(5, booksModel.getAvailableQuantity());
            preparedStatement.setDouble(6, booksModel.getPrice());
            preparedStatement.setLong(7, booksModel.getAuthorId());
            preparedStatement.setLong(8, booksModel.getPublisherId());
            preparedStatement.setString(9, booksModel.getImage());
            preparedStatement.setString(10, booksModel.getIsbn());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void changeImage(String isbn, String urlImage) {
        try {
            String sql = "UPDATE books SET " +
                    "images = ? " +
                    "WHERE isbn = ?";
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, urlImage);
            preparedStatement.setString(2, isbn);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public BooksModel selectByIsbn(String isbn) {
        String sql = "SELECT * FROM BOOKS WHERE isbn = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, isbn);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<BooksModel> booksModelList = this.getBooksModel(resultSet);
            return (booksModelList.size() > 0) ? booksModelList.get(0) : null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BooksModel> selectByAll(BooksModel booksModel) {
        String sql = "SELECT * FROM BOOKS WHERE " +
                "isbn = ? AND " +
                "title = ? AND " +
                "publication_date = ? AND " +
                "edition = ? AND " +
                "available_quantity = ? AND " +
                "price = ? AND " +
                "author = ? AND " +
                "publisher = ? AND " +
                "images = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, booksModel.getIsbn());
            preparedStatement.setString(2, booksModel.getTitle());
            preparedStatement.setDate(3, booksModel.getPublicationDate());
            preparedStatement.setInt(4, booksModel.getEdition());
            preparedStatement.setInt(5, booksModel.getAvailableQuantity());
            preparedStatement.setDouble(6, booksModel.getPrice());
            preparedStatement.setLong(7, booksModel.getAuthorId());
            preparedStatement.setLong(8, booksModel.getPublisherId());
            preparedStatement.setString(9, booksModel.getImage());

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getBooksModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BooksModel> selectByAuthor(String name) {
        String sql = "SELECT * FROM BOOKS " +
                "INNER JOIN AUTHORS A ON BOOKS.AUTHOR = A.ID " +
                "WHERE A.FIRST_NAME = ? OR A.SECOND_NAME = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getBooksModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BooksModel> selectByTitle(String title) {
        String sql = "SELECT * FROM BOOKS WHERE title = ?";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, title);

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getBooksModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BooksModel> selectAll() {
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "SELECT * FROM books";
            ResultSet resultSet = stmt.executeQuery(sql);

            return this.getBooksModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BooksModel> selectByGenres(int genresId) {
        String sql = "SELECT * FROM BOOKS " +
                "INNER JOIN BOOKS_GENRES BG on BOOKS.ISBN = BG.BOOK_ISBN " +
                "INNER JOIN GENRES G2 on BG.GENRE_ID = G2.ID " +
                "WHERE GENRE_ID = ?;";
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setInt(1, genresId);

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getBooksModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BooksModel> selectTop10BooksLatest() {
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "SELECT TOP (10) * FROM BOOKS ORDER BY PUBLICATION_DATE DESC";
            ResultSet resultSet = stmt.executeQuery(sql);

            return this.getBooksModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BooksModel> getSimilarBooks(BooksModel booksModel, List<String> genres) {
        String sql = "SELECT TOP(12) * FROM BOOKS " +
                "INNER JOIN BOOKS_GENRES BG on BOOKS.ISBN = BG.BOOK_ISBN " +
                "INNER JOIN GENRES G2 on BG.GENRE_ID = G2.ID WHERE BOOKS.ISBN NOT LIKE ? AND (";
        for (int i = 0; i < genres.size(); i++) {
            if (i == genres.size() - 1) {
                sql = sql + "G2.NAME = ?);";
            } else {
                sql = sql + "G2.NAME = ? OR ";
            }
        }
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setString(1, booksModel.getIsbn());
            for (int i = 0; i < genres.size(); i++) {
                preparedStatement.setString(i+2, genres.get(i));
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getBooksModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<BooksModel> getPaging(int index, int genresId) {
        String sql;
        if (genresId > 0) {
            sql = "SELECT * FROM BOOKS " +
                "INNER JOIN BOOKS_GENRES BG on BOOKS.ISBN = BG.BOOK_ISBN " +
                "INNER JOIN GENRES G2 on BG.GENRE_ID = G2.ID " +
                "WHERE GENRE_ID = ? " +
                "ORDER BY ISBN " +
                "OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY ";
        } else {
            sql = "SELECT * FROM BOOKS " +
                "ORDER BY ISBN " +
                "OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY ";
        }
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            preparedStatement.setInt(1, (index - 1) * 12);

            ResultSet resultSet = preparedStatement.executeQuery();

            return this.getBooksModel(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public int getTotalsBooks(int genresId) {
        int totalBooks = 0;
        String sql;
        if (genresId > 0) {
            sql = "SELECT COUNT(ISBN) AS TOTAL FROM  BOOKS " +
                "INNER JOIN BOOKS_GENRES BG on BOOKS.ISBN = BG.BOOK_ISBN " +
                "INNER JOIN GENRES G2 on BG.GENRE_ID = G2.ID " +
                "WHERE GENRE_ID = ?;";
        } else {
            sql = "SELECT COUNT(ISBN) AS TOTAL FROM  BOOKS";
        }
        try {
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);

            if (genresId > 0) {
                preparedStatement.setInt(1, genresId);
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                totalBooks = resultSet.getInt("TOTAL");
            }
            return totalBooks;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return totalBooks;
        }
    }
}