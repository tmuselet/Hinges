/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import entities.Adresse;
import entities.Groupe;
import entities.Profil;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import session.ProfilManager;

/**
 *
 * @author Martin
 */
@ManagedBean
@ViewScoped
public class ProfilBean {

    
    
    /*@EJB
    private ProfilManager profilManager;

    private Profil profil = new Profil();
    
    public ProfilBean() {
    }
    

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }*/
    
    
    /*public List<Profil> getProfils()
    {
        return profilManager.getAllProfils();
    }    
    
    public List<Profil> getProfilsByGroupe(Groupe groupe)
    {
        return profilManager.getProfilsByGroupe(groupe);
    }
    
    public void supprimer(Profil profil)
    {
        profilManager.delete(profil);
    }


    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
        
    public void ajouter()
    {

        //Adresse adresse = new Adresse(numero, rue, ville, cp);
        //nouveau.setAdresseId(adresse);
        profilManager.add(profil);
    }
   
}
