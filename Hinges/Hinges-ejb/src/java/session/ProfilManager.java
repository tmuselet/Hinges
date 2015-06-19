/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entities.Classe;
import entities.Groupe;
import entities.Profil;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Martin
 */
@Stateful
@LocalBean
public class ProfilManager {
    @PersistenceContext(unitName = "Hinges-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public void add(Profil profil){
        persist(profil);
    }
    
    public Profil update(Profil profil){
        return em.merge(profil);
    }

    public void delete(Profil profil){
        em.remove(profil);
    }
    
    public List<Profil> getAllProfils(){
        Query query = em.createNamedQuery("Profil.findAll");  
        return query.getResultList();
    }
    
    public List<Profil> getProfilsByGroupe(Groupe groupe){
        Query query = em.createNamedQuery("Profil.findAllByGroupe");  
        query.setParameter("groupe_id", groupe.getId());
        return query.getResultList();
    }

}
