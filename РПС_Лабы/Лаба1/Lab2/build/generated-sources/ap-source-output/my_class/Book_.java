package my_class;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import my_class.Client;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-25T09:10:56")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Date> birthday;
    public static volatile SingularAttribute<Book, Client> iDclient;
    public static volatile SingularAttribute<Book, String> author;
    public static volatile SingularAttribute<Book, Integer> iDbook;
    public static volatile SingularAttribute<Book, String> namebook;

}