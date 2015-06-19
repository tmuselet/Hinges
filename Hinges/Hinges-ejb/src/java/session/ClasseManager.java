/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entities.Classe;
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
public class ClasseManager {
    @PersistenceContext(unitName = "Hinges-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void add(Classe classe){
        persist(classe);
    }
    
    public Classe update(Classe classe){
        return em.merge(classe);
    }
    
    public Classe findClasseByName(String nom){
        Query query = em.createNamedQuery("Classe.findByNom");  
        query.setParameter("nom", nom);
        return (Classe) query.getSingleResult();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
