/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entities.Users;
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
public class UserManager {
    @PersistenceContext(unitName = "Hinges-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public Users connect(Users user){
        try{
            Query query = em.createNamedQuery("Users.find");  
            query.setParameter("login",user.getLogin());
            query.setParameter("password",user.getPassword());
            return (Users) query.getSingleResult();
        }catch(Exception e){
           return new Users(); 
        }
    }
    
    public void add(Users user){
        persist(user);
    }
    
    public Users update(Users user){
        return em.merge(user);
    }
}
