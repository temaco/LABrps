package my_class;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import my_class.Book;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-25T09:10:56")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> iDclient;
    public static volatile SingularAttribute<Client, String> fullname;
    public static volatile ListAttribute<Client, Book> bookList;

}