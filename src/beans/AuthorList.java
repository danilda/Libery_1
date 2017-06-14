package beans;

import db.DAOLibery;
import db.OracleDAO;
import db.dbExeptions.DataNotFoundException;

import java.util.List;

/**
 * Created by danil on 12.06.2017.
 */
public class AuthorList {

    public List<Author> getAllAuthors() throws DataNotFoundException {
        DAOLibery dao = new OracleDAO();
        return dao.getAllAuthors();
    }
}
