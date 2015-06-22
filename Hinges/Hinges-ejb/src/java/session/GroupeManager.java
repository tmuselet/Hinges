/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entities.Groupe;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Martin
 */
@Stateful
@LocalBean
public class GroupeManager {
    @PersistenceContext(unitName = "Hinges-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void add(Groupe groupe){
        persist(groupe);
    }
    
    public Groupe update(Groupe groupe){
        return em.merge(groupe);
    }
    
    public void delete(Groupe groupe){
        em.remove(groupe);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
