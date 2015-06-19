/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entities.Tarifs;
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
public class TarifManager {
    @PersistenceContext(unitName = "Hinges-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void add(Tarifs tarif){
        persist(tarif);
    }
    
    public Tarifs update(Tarifs tarif){
        return em.merge(tarif);
    }
    
    public Float findByName(String nom){
        Query query = em.createNamedQuery("Tarifs.findByNom");  
        query.setParameter("nom", nom);
        return (Float) query.getSingleResult();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
