package db;

import beans.Author;
import beans.Book;
import beans.Genre;
import beans.Publisher;
import db.dbExeptions.DataNotFoundException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by danil on 10.06.2017.
 */
public class OracleDAO implements DAOLibery{
    private static final String SELECT_ALL_GENRES = "SELECT * FROM GENRE";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM BOOK";
    private static final String SELECT_ALL_AUTHORS = "SELECT * FROM author";
    private static final String SELECT_ALL_PUBLISHERS = "SELECT * FROM publisher";
    private static final String INSERT_INTO_BOOK = "INSERT INTO " +
            "book( name, content, page_count, isbn, genre_id, author_id, publish_year, publisher_id, image)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ACCOUNT_BY_LOGIN = "SELECT * FROM users " +
            "WHERE login = ?";

    private Connection connection = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private  static final OracleDAO instance = new OracleDAO();

    public static OracleDAO getInstance(){
        return instance;
    }

    @Override
    public void connect() throws SQLException {
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/OracleDataSource");
            connection = ds.getConnection();
        } catch (NamingException e) {
            System.out.println("Naming problem with connect");
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
            ps.close();
            if(rs != null)
            rs.close();
        } catch (SQLException e) {
            System.out.println("SQL problem with disconnect");
            e.printStackTrace();
        }
    }


    @Override
    public List<Genre> getAllGenres() throws DataNotFoundException{
        try {
            connect();
            List<Genre> names = unhandledSelectAllGenres();
            System.out.println(names);
            if(names == null || names.size() == 0)
                throw new DataNotFoundException();
            return names;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }


    private List<Genre> unhandledSelectAllGenres() throws SQLException{
        List<Genre> genres = new LinkedList<>();
        ps = connection.prepareStatement(SELECT_ALL_GENRES);
        rs = ps.executeQuery();
        if(rs !=null)
            while (rs.next()){
                Genre genre = new Genre();
                genre.setId(rs.getInt("id"));
                genre.setName(rs.getString("name"));
                genres.add(genre);
            }
        return genres;
    }

    /**
    * deprecated
    * */
    @Override
    public boolean insertBook(Book book) {
        boolean result = false;
        try {
            connect();
            ps = connection.prepareStatement(INSERT_INTO_BOOK);
            ps.setString(1, book.getName());
            ps.setBinaryStream(2, book.getContentInputStream(), book.getContent().length());
            ps.setInt(3, book.getPageCount());
            ps.setString(4, book.getIsbn());
            ps.setInt(5, book.getGenreId());
            ps.setInt(6, book.getAuthorId());
            ps.setDate(7, new Date(book.getPublishYear().get(Calendar.YEAR)));
            ps.setInt(8, book.getPublisherId());
            ps.setBinaryStream(9, book.getImageInputStream());
            result = ps.execute();
            System.out.println("sad");
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } finally {
            disconnect();
        }
    }

    @Override
    public boolean isAccountValid(String login, String pass) {
        return false;
    }

    @Override
    public boolean isLoginExist(String login) {
        try {
            connect();
            return unhandledIsLoginExist(login);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return false;
    }

    private boolean unhandledIsLoginExist(String login) throws SQLException {
        ps = connection.prepareStatement(GET_ACCOUNT_BY_LOGIN);
        ps.setString(1, login);
        return ps.executeQuery().next();
    }

    @Override
    public List<Book> getAllBooks() throws DataNotFoundException{
        try{
            connect();
            List<Book> books = unhandledGetAllBooks();
            if (books.size() == 0)
                throw new DataNotFoundException("Books didn't exist");
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }

    /**
     * TODO add Image and Content
     */
    private List<Book> unhandledGetAllBooks() throws SQLException {
        List<Book> allBooks = new LinkedList<>();
        ps = connection.prepareStatement( SELECT_ALL_BOOKS);
        rs = ps.executeQuery();
        if(rs != null)
            while(rs.next()){
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
    //            book.setContent( rs.getBinaryStream(3));
                book.setPageCount(rs.getInt(4));
                book.setIsbn(rs.getString(5));
                book.setGenreId(rs.getInt(6));
                book.setAuthorId(rs.getInt(7));
                GregorianCalendar publishYear = new GregorianCalendar();
                publishYear.setTime(rs.getDate(8));
                book.setPublishYear(publishYear);
                book.setPublisherId(rs.getInt(9));
    //            book.setImage(rs.getBinaryStream(10));
                allBooks.add(book);
            }
        return allBooks;
    }

    @Override
    public List<Author> getAllAuthors() throws DataNotFoundException {
        try{
            connect();
            List<Author> authors = unhandledGetAllAuthors();
            if(authors.size() == 0)
                throw new DataNotFoundException("Authors didn't exist");
            return authors;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            disconnect();
        }
        return null;
    }

    private List<Author> unhandledGetAllAuthors() throws SQLException{
        List<Author> authors = new LinkedList<>();
        ps = connection.prepareStatement(SELECT_ALL_AUTHORS);
        rs = ps.executeQuery();
        if(rs != null)
            while (rs.next()){
                Author author = new Author();
                author.setId(rs.getInt(1));
                author.setName(rs.getString(2));
                GregorianCalendar birthday = new GregorianCalendar();
                birthday.setTime(rs.getDate(3));
                author.setBirthday(birthday);
                authors.add(author);
            }
        return authors;
    }

    @Override
    public List<Publisher> getAllPublishers() throws DataNotFoundException{
        try {
            connect();
            List<Publisher> publishers = unhandledGetAllPublishers();
            if(publishers.size() == 0)
                throw new DataNotFoundException("Publishers didn't exist");
            return publishers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Publisher> unhandledGetAllPublishers() throws SQLException {
        List<Publisher> publishers = new LinkedList<>();
        ps = connection.prepareStatement(SELECT_ALL_PUBLISHERS);
        rs = ps.executeQuery();
        if(rs != null)
            while (rs.next()){
                Publisher publisher = new Publisher();
                publisher.setId(rs.getInt(1));
                publisher.setName(rs.getString(2));
                publishers.add(publisher);
            }
        return publishers;
    }

}
