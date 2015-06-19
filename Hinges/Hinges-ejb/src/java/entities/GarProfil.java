/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "GAR_PROFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GarProfil.findAll", query = "SELECT g FROM GarProfil g"),
    @NamedQuery(name = "GarProfil.findById", query = "SELECT g FROM GarProfil g WHERE g.id = :id"),
    @NamedQuery(name = "GarProfil.findByMatin1", query = "SELECT g FROM GarProfil g WHERE g.matin1 = :matin1"),
    @NamedQuery(name = "GarProfil.findByMatin2", query = "SELECT g FROM GarProfil g WHERE g.matin2 = :matin2"),
    @NamedQuery(name = "GarProfil.findByDureeSoir", query = "SELECT g FROM GarProfil g WHERE g.dureeSoir = :dureeSoir")})
public class GarProfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MATIN1")
    private Boolean matin1;
    @Column(name = "MATIN2")
    private Boolean matin2;
    @Column(name = "DUREE_SOIR")
    private Integer dureeSoir;
    @JoinColumn(name = "ID_PROFIL", referencedColumnName = "ID")
    @ManyToOne
    private Profil idProfil;
    @JoinColumn(name = "ID_GAR", referencedColumnName = "ID")
    @ManyToOne
    private Garderie idGar;

    public GarProfil() {
    }

    public GarProfil(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getMatin1() {
        return matin1;
    }

    public void setMatin1(Boolean matin1) {
        this.matin1 = matin1;
    }

    public Boolean getMatin2() {
        return matin2;
    }

    public void setMatin2(Boolean matin2) {
        this.matin2 = matin2;
    }

    public Integer getDureeSoir() {
        return dureeSoir;
    }

    public void setDureeSoir(Integer dureeSoir) {
        this.dureeSoir = dureeSoir;
    }

    public Profil getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(Profil idProfil) {
        this.idProfil = idProfil;
    }

    public Garderie getIdGar() {
        return idGar;
    }

    public void setIdGar(Garderie idGar) {
        this.idGar = idGar;
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
        if (!(object instanceof GarProfil)) {
            return false;
        }
        GarProfil other = (GarProfil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GarProfil[ id=" + id + " ]";
    }
    
}
