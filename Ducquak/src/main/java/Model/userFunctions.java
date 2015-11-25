/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
import java.util.UUID;

/**
 *
 * @author NSERW
 */
public class userFunctions {
    Cluster cluster;
    public userFunctions()
    {
      //Cluster cluster=null;   
    }
    
    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
    
    public boolean registerUser(UUID userID, String username, String Password)
    {
        Session s = cluster.connect("ducquak");
        PreparedStatement pS = s.prepare("INSERT INTO users (userID,userName,password) Values (?,?,?)");
        BoundStatement boundStatement = new BoundStatement(pS);
        s.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        userID,username,Password));
        //We are assuming this always works.  Also a transaction would be good here !
        
        return true;
        
    }
}
