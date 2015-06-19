/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Martin
 */
@Entity
@Table(name = "PROFIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profil.findAll", query = "SELECT p FROM Profil p"),
    @NamedQuery(name = "Profil.findById", query = "SELECT p FROM Profil p WHERE p.id = :id"),
    @NamedQuery(name = "Profil.findByNom", query = "SELECT p FROM Profil p WHERE p.nom = :nom"),
    @NamedQuery(name = "Profil.findByPrenom", query = "SELECT p FROM Profil p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Profil.findByTel", query = "SELECT p FROM Profil p WHERE p.tel = :tel"),
    @NamedQuery(name = "Profil.findByRemarques", query = "SELECT p FROM Profil p WHERE p.remarques = :remarques")})
public class Profil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 30)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 30)
    @Column(name = "TEL")
    private String tel;
    @Size(max = 30)
    @Column(name = "REMARQUES")
    private String remarques;
    @OneToMany(mappedBy = "idProfil")
    private List<GarProfil> garProfilList;
    @OneToMany(mappedBy = "idProfil")
    private List<TapProfil> tapProfilList;
    @OneToMany(mappedBy = "idProfil")
    private List<RepasProfil> repasProfilList;
    @JoinColumn(name = "GROUPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Groupe groupeId;
    @JoinColumn(name = "CLASSE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Classe classeId;
    @JoinColumn(name = "ADRESSE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Adresse adresseId;

    public Profil() {
    }

    public Profil(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    @XmlTransient
    public List<GarProfil> getGarProfilList() {
        return garProfilList;
    }

    public void setGarProfilList(List<GarProfil> garProfilList) {
        this.garProfilList = garProfilList;
    }

    @XmlTransient
    public List<TapProfil> getTapProfilList() {
        return tapProfilList;
    }

    public void setTapProfilList(List<TapProfil> tapProfilList) {
        this.tapProfilList = tapProfilList;
    }

    @XmlTransient
    public List<RepasProfil> getRepasProfilList() {
        return repasProfilList;
    }

    public void setRepasProfilList(List<RepasProfil> repasProfilList) {
        this.repasProfilList = repasProfilList;
    }

    public Groupe getGroupeId() {
        return groupeId;
    }

    public void setGroupeId(Groupe groupeId) {
        this.groupeId = groupeId;
    }

    public Classe getClasseId() {
        return classeId;
    }

    public void setClasseId(Classe classeId) {
        this.classeId = classeId;
    }

    public Adresse getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(Adresse adresseId) {
        this.adresseId = adresseId;
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
        if (!(object instanceof Profil)) {
            return false;
        }
        Profil other = (Profil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Profil(String nom, String prenom, String tel, String remarques) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.remarques = remarques;
    }
    
    

    @Override
    public String toString() {
        return "entities.Profil[ id=" + id + " ]";
    }
    
}
