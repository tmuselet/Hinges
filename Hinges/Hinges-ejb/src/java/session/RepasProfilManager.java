/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entities.RepasProfil;
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
public class RepasProfilManager {
    @PersistenceContext(unitName = "Hinges-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void add(RepasProfil repasProfil){
        persist(repasProfil);
    }
    
    public RepasProfil update(RepasProfil repasProfil){
        return em.merge(repasProfil);
    }
    
    public void delete(RepasProfil repasProfil){
        em.remove(repasProfil);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
