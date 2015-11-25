/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import java.util.UUID;

/**
 *
 * @author NSERW
 */
public class userLogin {
    
    String username = null;
    Boolean loggedIn = false;
    
    
    public userLogin()
    {
        
    }
    
    public String getUserName()
    {
        return username;
    }
    
    public void setUserName(String username)
    {
        this.username = username;
    }
    
    public boolean setLogIn()
    {
        return loggedIn = true;
    }
    
    public boolean setLogOut()
    {
        return loggedIn = false;
    }
    
    public Boolean getLoginStatus()
    {
        return loggedIn;
    }
    
    public void setLoginState(boolean logedin){
        this.loggedIn=logedin;
    }
    
    
}
