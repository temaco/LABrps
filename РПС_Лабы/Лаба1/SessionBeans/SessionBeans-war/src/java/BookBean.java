
import book.Book;
import ejb.BookFacadeLocal;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;


@RequestScoped
public class BookBean {
public BookBean(){
book = new Book();
}
private Book book;

@EJB
private static BookFacadeLocal bookFacade;
public void setUser(Book book) {
this.book = book;
}

public Book getBook() {
return book;
}
public String create() {
bookFacade.create(book);
return "index";
}
public List findAll() {
        return null;

}
}

