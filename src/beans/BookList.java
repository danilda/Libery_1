package beans;

import db.DAOLibery;
import db.OracleDAO;
import db.dbExeptions.DataNotFoundException;

import java.util.List;

/**
 * Created by danil on 12.06.2017.
 */
public class BookList {

    public List<Book> getAllBooks() throws DataNotFoundException {
        DAOLibery dao = new OracleDAO();
        return dao.getAllBooks();
    }
}
