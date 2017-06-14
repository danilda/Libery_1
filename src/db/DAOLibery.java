package db;

import beans.*;
import db.dbExeptions.DataNotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by danil on 10.06.2017.
 */
public interface DAOLibery {

    void connect() throws SQLException;

    void disconnect();

    boolean insertBook(Book book);

    boolean isAccountValid(String login, String pass);

    boolean isLoginExist(String login);

    List<Author> getAllAuthors() throws DataNotFoundException;

    List<Book> getAllBooks() throws DataNotFoundException;

    List<Genre> getAllGenres() throws DataNotFoundException;

    List<Publisher> getAllPublishers() throws DataNotFoundException;

    ResultSet getBooksByGenre(String genreID) throws DataNotFoundException;
}
