/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Library.AeSimpleSHA1;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
import static com.datastax.driver.core.querybuilder.QueryBuilder.set;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
    
    public boolean registerUser(String username, String Password)
    {
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session s = cluster.connect("ducquak");
        PreparedStatement pS = s.prepare("INSERT INTO users (userName,password) Values (?,?)");
        BoundStatement boundStatement = new BoundStatement(pS);
        s.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username,EncodedPassword));
        //We are assuming this always works.  Also a transaction would be good here !
        
        return true;
        
    }
    
    public boolean validateUser(String username, String password)
    {
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        
        Session session = cluster.connect("ducquak");
        PreparedStatement pS = session.prepare("SELECT * FROM users");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(pS);
        rs = session.execute( // this is where the query is executed
                boundStatement // here you are binding the 'boundStatement'
                        );
        if (rs.isExhausted()) {
            System.out.println("Nothing returned");
            return false;
        } else {
            for (Row row : rs) {
               
                String userName = row.getString("userName");
                if(userName.equals(username))
                {
                    String StoredPass = row.getString("password");
                if (StoredPass.compareTo(EncodedPassword) == 0)
                    return true;
                }
               
            }
        }
        return false;
        }
    
    
    
    public void changePassword(String username, String newPassword)
    {
        Session session = cluster.connect("ducquak");
        Statement s00;
        s00 = QueryBuilder.select()
               .all()
               .from("ducquak","users");
        ResultSet rs = session.execute(s00);
        for(Row row : rs)
        {
            String olduserName = row.getString("userName");
            if(olduserName.equals(username))
            {
                Statement s01 = QueryBuilder.update("ducquak","users")
                        .with(set("password", username))
                        .where(eq("password",olduserName));
            session.execute(s01);
            }
        }
    }
}

