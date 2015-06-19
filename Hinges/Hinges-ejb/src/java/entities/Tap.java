/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "TAP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tap.findAll", query = "SELECT t FROM Tap t"),
    @NamedQuery(name = "Tap.findById", query = "SELECT t FROM Tap t WHERE t.id = :id"),
    @NamedQuery(name = "Tap.findByDate", query = "SELECT t FROM Tap t WHERE t.date = :date")})
public class Tap implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(mappedBy = "idTap")
    private List<TapProfil> tapProfilList;

    public Tap() {
    }

    public Tap(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public List<TapProfil> getTapProfilList() {
        return tapProfilList;
    }

    public void setTapProfilList(List<TapProfil> tapProfilList) {
        this.tapProfilList = tapProfilList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tap)) {
            return false;
        }
        Tap other = (Tap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tap[ id=" + id + " ]";
    }
    
}
