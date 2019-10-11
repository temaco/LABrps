/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
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
import javax.xml.bind.annotation.XmlRootElement;

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
public class ClientEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iDclient;
    @Column(name = "Full_name")
    private String fullname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDclient")
    private List<BookEntity> bookList;
    
    public Long getId() {
        return getiDclient();
    }

    public void setId(Long iDclient) {
        this.setiDclient(iDclient);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getiDclient() != null ? getiDclient().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientEntity)) {
            return false;
        }
        ClientEntity other = (ClientEntity) object;
        if ((this.getiDclient() == null && other.getiDclient() != null) || (this.getiDclient() != null && !this.iDclient.equals(other.iDclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.ClientEntity[ id=" + getiDclient() + " ]";
    }

    /**
     * @return the iDclient
     */
    public Long getiDclient() {
        return iDclient;
    }

    /**
     * @param iDclient the iDclient to set
     */
    public void setiDclient(Long iDclient) {
        this.iDclient = iDclient;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the bookList
     */
    public List<BookEntity> getBookList() {
        return bookList;
    }

    /**
     * @param bookList the bookList to set
     */
    public void setBookList(List<BookEntity> bookList) {
        this.bookList = bookList;
    }
    
}
