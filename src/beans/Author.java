package beans;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by danil on 12.06.2017.
 */
public class Author {
    private int id;
    private String name;
    private GregorianCalendar birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getBirthday() {
        return birthday;
    }

    public void setBirthday(GregorianCalendar birthday) {
        this.birthday = birthday;
    }
}
