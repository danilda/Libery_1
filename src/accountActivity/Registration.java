package accountActivity;

import db.DAOLibery;
import db.OracleDAO;

/**
 * Created by danil on 11.06.2017.
 */
public class Registration {

    private boolean isValidNewAccount(String login){
        DAOLibery dao = new OracleDAO();
        return !dao.isLoginExist(login);
    }

    public boolean doRegistration(String login, String pass){
        return false;
    }

    private void sendPassForRegistration(String login){

    }

}
