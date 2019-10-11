package my_class;
import java.util.ArrayList;
import javax.servlet.ServletException;

public class book {
    private int ID_book;
    private String Name_book;
    private String Author;
    private String Birthday;
    
    private SessionManagedBean session;
    
    public void setSession(SessionManagedBean session) {
        this.session = session;
    }

    public SessionManagedBean getSession() {
        return session;
    }

    /**
     * Creates a new instance of User
     */
    public book() {
    }
    public ArrayList<book> getAll() {
        return (ArrayList) new DAO.DAO_book().getAll();
    }
    public ArrayList<book> getError() throws ServletException {
            throw new Error();
    }

    public String create() {
        book Object = new book();
        Object.ID_book = ID_book;
        Object.Name_book = Name_book;
        Object.Author = Author;
        Object.Birthday = Birthday; 
        new DAO.DAO_book().create(Object);
        return "success";
    }
        public String update() {
        book Object = new book();
        Object.ID_book = ID_book;
        Object.Name_book = Name_book;
        Object.Author = Author;
        Object.Birthday = Birthday;
        new DAO.DAO_book().update(Object);
        return "index";
    }

    public int getID_book() {
        return ID_book;
    }

    public void setID_book(int ID_book) {
        this.ID_book = ID_book;
    }

    public String getName_book() {
        return Name_book;
    }

    public void setName_book(String Name_book) {
        this.Name_book = Name_book;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }
}
