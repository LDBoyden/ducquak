/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;
import com.datastax.driver.core.*;
/**
 *
 * @author NSERW
 */
public final class keyspacesDQ {
    public void createDBC(Cluster c)
    {
     try {
        String createKeySpace = "create keyspace if not exists ducQuak  WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
        String createanonymousUsers = "CREATE TABLE if not exists ducQuak.users ("
                + "userID uuid, "
                + "points int,"
                + "password text,"
                + "threads list,"
                + " PRIMARY KEY (userID)"
                + ")";
        String createThreads = "CREATE TABLE if not exists ducQuak.threads ("
                + "threadID uuid,"
                + "threadName text,"
                + "votes int,"
                + "members list,"
                + "numberOfMembers int,"
                + "PRIMARY KEY (threadID)"
                + ")";
        String createPostsTable = "CREATE TABLE if not exists ducQuaks.posts ("
                + "threadID uuid,"
                + "postID uuid,"
                + "userID uuid,"
                + "postedTime timestamp,"
                + "votedNumber int"
                + "boolean picture"
                + "PRIMARY KEY (postID)";
        String createPostPics = "CREATE TABLE if not exists ducQuaks.picsList ("
                + "postID uuid,"
                + "picture blob,"
                + "pictureID uuid,"
                + "postedTime timestamp,"
                + "PRIMARY KEY(pictureID, postID)";
        Session session = c.connect();
        }
        catch (Exception ex)
        {
            System.out.println("Something like major wrong here!");
        }
}
}
