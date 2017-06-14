package beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.GregorianCalendar;

/**
 * Created by danil on 10.06.2017.
 */
public class Book {
    private int id;
    private String name;
    private File content;
    private int pageCount;
    private String isbn;
    private int genreId;
    private int authorId;
    private GregorianCalendar publishYear;
    private int publisherId;
    private File image;

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

    public File getContent() {
        return content;
    }

    public void setContent(File content) {
        this.content = content;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public GregorianCalendar getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(GregorianCalendar publishYear) {
        this.publishYear = publishYear;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public InputStream getContentInputStream(){
        return getInputStream(content);
    }

    public InputStream getImageInputStream(){
        return getInputStream(image);
    }

    private InputStream getInputStream(File file){
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputStream;
    }
}
