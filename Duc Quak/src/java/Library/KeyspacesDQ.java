/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import org.apache.catalina.Cluster;

/**
 *
 * @author NSERW
 */
public class KeyspacesDQ {
    
    public KeyspacesDQ()
    {
        
    }
    
    public static void setUpKeyspace(Cluster c)
    {
        String createKeySpace = "create keyspace if not exists ducQuak  WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
        String createanonymousUsers = "CREATE TABLE if not exists ducQuak.users ("
                + "userID uuid, "
                + "points int,"
                + " PRIMARY KEY (userID)"
                + ")";
    }
}
