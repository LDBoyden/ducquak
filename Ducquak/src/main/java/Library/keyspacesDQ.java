package Library;

import com.datastax.driver.core.*;

/**
 *
 * @author NSERW
 */
public final class keyspacesDQ {

    public keyspacesDQ() {

    }

    public static void createDBC(Cluster c) {
        try {
            String createKeySpace = "create keyspace if not exists ducquak  WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
            String createanonymousUsers = "CREATE TABLE if not exists ducquak.users ("
                    + "userID uuid,"
                    + "userName text,"
                    + "points int,"
                    + "password text,"
                    + "threads text,"
                    + " PRIMARY KEY (userID)"
                    + ")";
            String loginSecInd = "CREATE INDEX user_index ON instagrim.userprofiles (userName);";

            String createThreads = "CREATE TABLE if not exists ducquak.threads ("
                    + "threadID uuid,"
                    + "threadName text,"
                    + "longtitute float,"
                    + "langtitude float,"
                    + "numberOfMembers int,"
                    + "threadAdmin uuid,"
                    + "description text,"
                    + "maximumMembers int"
                    + "PRIMARY KEY (threadID)"
                    + ")";
            String createPostsTable = "CREATE TABLE if not exists ducquak.posts ("
                    + "threadID uuid,"
                    + "postID uuid,"
                    + "userID uuid,"
                    + "postedTime timestamp,"
                    + "votedNumber int,"
                    + "picture boolean,"
                    + "PRIMARY KEY (postID)";
            String createPostPics = "CREATE TABLE if not exists ducquak.picsList ("
                    + "postID uuid,"
                    + "picture blob,"
                    + "pictureID uuid,"
                    + "postedTime timestamp,"
                    + "PRIMARY KEY(pictureID)";
            String userThreads = "CREATE TABLE if not exists ducquak.userThreads ("
                    + "userID uuid"
                    + "threadID uuid"
                    + "PRIMARY KEY (userID)";
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
            try {
                SimpleStatement cqlQuery = new SimpleStatement(loginSecInd);
                session.execute(cqlQuery);

            } catch (Exception et) {
                System.out.println("Can't create Address Profile " + et);
            }
            System.out.println("" + createanonymousUsers);
            try {
                SimpleStatement cqlQuery = new SimpleStatement(createThreads);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Cant create following table " + et);
            }
            System.out.println("" + createThreads);
            try {
                SimpleStatement cqlQuery = new SimpleStatement(createPostsTable);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create the following");
            }
            System.out.println("" + createPostsTable);
            try {
                SimpleStatement cqlQuery = new SimpleStatement(createPostPics);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Cant create posts pics");
            }
            System.out.println("" + createPostPics);
            session.close();
            try {
                SimpleStatement cqlQuery = new SimpleStatement(userThreads);
                session.execute(cqlQuery);

            } catch (Exception et) {
                System.out.println("Can't create User Threads " + et);
            }
            System.out.println("" + userThreads);
        } catch (Exception ex) {
            System.out.println("Something like major wrong here!");
        }

    }
}
