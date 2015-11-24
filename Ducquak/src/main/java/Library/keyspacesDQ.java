package Library;
import com.datastax.driver.core.*;
/**
 *
 * @author NSERW
 */
public final class keyspacesDQ {
    
    public keyspacesDQ()
    {
        
    }
    
    public void createDBC(Cluster c)
    {
     try {
        String createKeySpace = "create keyspace if not exists ducQuak  WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
        String createanonymousUsers = "CREATE TABLE if not exists ducQuak.users ("
                + "userID uuid,"
                + "userName text,"
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
        try {
                PreparedStatement statement = session
                        .prepare(createKeySpace);
                BoundStatement boundStatement = new BoundStatement(
                        statement);
                ResultSet rs = session
                        .execute(boundStatement);
                System.out.println("created database ");
            } catch (Exception et) {
                System.out.println("Can't create database yoo " + et);
            }
        try {
            SimpleStatement cqlQuery = new SimpleStatement(createanonymousUsers);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create following table " + et);
            }
            System.out.println("" + createanonymousUsers);
        try 
            {
                SimpleStatement cqlQuery = new SimpleStatement(createThreads);
                    session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Cant create following table " + et);
            }
            System.out.println("" + createThreads);
        try 
            {
                SimpleStatement cqlQuery = new SimpleStatement(createPostsTable);
                    session.execute(cqlQuery);
            } catch (Exception et) 
            {
                System.out.println("Can't create the following");
            }
            System.out.println("" + createPostsTable);
        try 
            {
                SimpleStatement cqlQuery = new SimpleStatement(createPostPics);
                    session.execute(cqlQuery);
            } catch (Exception et)
            {
                System.out.println("Cant create posts pics");
            }
            System.out.println("" + createPostPics);
            session.close();
        }
         
        catch (Exception ex)
        {
            System.out.println("Something like major wrong here!");
        }
     
}
}
