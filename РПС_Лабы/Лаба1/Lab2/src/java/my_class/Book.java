/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_class;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_book")
    private Integer iDbook;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 20)
    @Column(name = "Name_book")
    private String namebook;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 20)
    @Column(name = "Author")
    private String author;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "Birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @JoinColumn(name = "ID_client", referencedColumnName = "ID_client")
    @ManyToOne(optional = false)
    private Client iDclient;

    public Book() {
    }

    public Book(Integer iDbook) {
        this.iDbook = iDbook;
    }

    public Book(Integer iDbook, String namebook, String author, Date birthday) {
        this.iDbook = iDbook;
        this.namebook = namebook;
        this.author = author;
        this.birthday = birthday;
    }

    public Integer getIDbook() {
        return iDbook;
    }

    public void setIDbook(Integer iDbook) {
        this.iDbook = iDbook;
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

    public Client getIDclient() {
        return iDclient;
    }

    public void setIDclient(Client iDclient) {
        this.iDclient = iDclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDbook != null ? iDbook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.iDbook == null && other.iDbook != null) || (this.iDbook != null && !this.iDbook.equals(other.iDbook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my_class.Book[ iDbook=" + iDbook + " ]";
    }
    
}
