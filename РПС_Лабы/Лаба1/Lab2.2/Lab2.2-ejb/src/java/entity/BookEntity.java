/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roman
 */

@Entity
@Table(name = "book", catalog = "book", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
    , @NamedQuery(name = "Book.findByIDbook", query = "SELECT b FROM Book b WHERE b.iDbook = :iDbook")
    , @NamedQuery(name = "Book.findByNamebook", query = "SELECT b FROM Book b WHERE b.namebook = :namebook")
    , @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author")
    , @NamedQuery(name = "Book.findByBirthday", query = "SELECT b FROM Book b WHERE b.birthday = :birthday")})
public class BookEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_book")
    private Long iDBook;
    @JoinColumn(name = "ID_client", referencedColumnName = "ID_client")
    @ManyToOne(optional = false)
    private ClientEntity iDclient;
    @Column(name = "Name_book")
    private String namebook;
    @Column(name = "Author")
    private String author;
    @Column(name = "Birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    public Long getId() {
        return getiDBook();
    }

    public void setId(Long iDBook) {
        this.setiDBook(iDBook);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getiDBook() != null ? getiDBook().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookEntity)) {
            return false;
        }
        BookEntity other = (BookEntity) object;
        if ((this.getiDBook() == null && other.getiDBook() != null) || (this.getiDBook() != null && !this.iDBook.equals(other.iDBook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.BookEntity[ id=" + getiDBook() + " ]";
    }

    public Long getiDBook() {
        return iDBook;
    }

    public void setiDBook(Long iDBook) {
        this.iDBook = iDBook;
    }

    public ClientEntity getiDclient() {
        return iDclient;
    }


    public void setiDclient(ClientEntity iDclient) {
        this.iDclient = iDclient;
    }

  
    public String getNamebook() {
        return namebook;
    }


    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }


    public String getAuthor() {
        return author;
    }

  
    public void setAuthor(String author) {
        this.author = author;
    }

 
    public Date getBirthday() {
        return birthday;
    }

 
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BookEntity() {
    }
    
}
