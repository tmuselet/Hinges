/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entities.TapProfil;
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
public class TapProfilManager {

    @PersistenceContext(unitName = "Hinges-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void add(TapProfil tapProfil){
        persist(tapProfil);
    }
    
    public TapProfil update(TapProfil tapProfil){
        return em.merge(tapProfil);
    }
    
    public void delete(TapProfil tapProfil){
        em.remove(tapProfil);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
