/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import entities.Users;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import session.UserManager;

/**
 *
 * @author Martin
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserManager userManager;
    
    private Users user = new Users();
    
    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }
  
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    public String connect(){
      Users userValid = userManager.connect(user);
      if(userValid.getLogin().equals("")){
          return "error";
      }else{
          return userValid.getUrl();
      }
    }
}
