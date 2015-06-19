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
@Table(name = "REPAS_PROFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepasProfil.findAll", query = "SELECT r FROM RepasProfil r"),
    @NamedQuery(name = "RepasProfil.findById", query = "SELECT r FROM RepasProfil r WHERE r.id = :id"),
    @NamedQuery(name = "RepasProfil.findByHorsDelai", query = "SELECT r FROM RepasProfil r WHERE r.horsDelai = :horsDelai"),
    @NamedQuery(name = "RepasProfil.findByAbsent", query = "SELECT r FROM RepasProfil r WHERE r.absent = :absent")})
public class RepasProfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "HORS_DELAI")
    private Boolean horsDelai;
    @Column(name = "ABSENT")
    private Boolean absent;
    @JoinColumn(name = "ID_REPAS", referencedColumnName = "ID")
    @ManyToOne
    private Repas idRepas;
    @JoinColumn(name = "ID_PROFIL", referencedColumnName = "ID")
    @ManyToOne
    private Profil idProfil;

    public RepasProfil() {
    }

    public RepasProfil(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getHorsDelai() {
        return horsDelai;
    }

    public void setHorsDelai(Boolean horsDelai) {
        this.horsDelai = horsDelai;
    }

    public Boolean getAbsent() {
        return absent;
    }

    public void setAbsent(Boolean absent) {
        this.absent = absent;
    }

    public Repas getIdRepas() {
        return idRepas;
    }

    public void setIdRepas(Repas idRepas) {
        this.idRepas = idRepas;
    }

    public Profil getIdProfil() {
        return idProfil;
    }

    public void setIdProfil(Profil idProfil) {
        this.idProfil = idProfil;
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
        if (!(object instanceof RepasProfil)) {
            return false;
        }
        RepasProfil other = (RepasProfil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RepasProfil[ id=" + id + " ]";
    }
    
}
