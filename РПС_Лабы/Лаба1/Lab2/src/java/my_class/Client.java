/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_class;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author roman
 */
@Entity
@Table(name = "client", catalog = "book", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByIDclient", query = "SELECT c FROM Client c WHERE c.iDclient = :iDclient")
    , @NamedQuery(name = "Client.findByFullname", query = "SELECT c FROM Client c WHERE c.fullname = :fullname")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_client")
    private Integer iDclient;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(name = "Full_name")
    private String fullname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDclient")
    private List<Book> bookList;

    public Client() {
    }

    public Client(Integer iDclient) {
        this.iDclient = iDclient;
    }

    public Client(Integer iDclient, String fullname) {
        this.iDclient = iDclient;
        this.fullname = fullname;
    }

    public Integer getIDclient() {
        return iDclient;
    }

    public void setIDclient(Integer iDclient) {
        this.iDclient = iDclient;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @XmlTransient
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDclient != null ? iDclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.iDclient == null && other.iDclient != null) || (this.iDclient != null && !this.iDclient.equals(other.iDclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "my_class.Client[ iDclient=" + iDclient + " ]";
    }
    
}
