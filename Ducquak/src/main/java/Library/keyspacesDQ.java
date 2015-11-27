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
                    + "userName text,"
                    + "points int,"
                    + "password text,"
                    + "threads text,"
                    + " PRIMARY KEY (userName)"
                    + ")";
            String createThreads = "CREATE TABLE if not exists ducquak.threads ("
                    + "threadID uuid,"
                    + "threadName text,"
                    + "longtitute float,"
                    + "langtitude float,"
                    + "numberOfMembers int,"
                    + "threadAdmin text,"
                    + "description text,"
                    + "maximumMembers int,"
                    + "PRIMARY KEY (threadID)"
                    + ")";
            String createPostsTable = "CREATE TABLE if not exists ducquak.posts ("
                    + "threadID uuid,"
                    + "postID uuid,"
                    + "userID uuid,"
                    + "postedTime timestamp,"
                    + "votedNumber int,"
                    + "picture boolean,"
                    + "PRIMARY KEY (postID)"
                    + ")";
            String createPostPics = "CREATE TABLE if not exists ducquak.picsList ("
                    + "postID uuid,"
                    + "picture blob,"
                    + "pictureID uuid,"
                    + "postedTime timestamp,"
                    + "PRIMARY KEY(pictureID)"
                    + ")";
            String userThreads = "CREATE TABLE if not exists ducquak.userthreads ("
                    + "userName text,"
                    + "threadID uuid,"
                    + "PRIMARY KEY (userName,threadID)"
                    + ")";
            //String userThreadsIndex = "CREATE INDEX threadIndex ON ducquak.usersthreads(threadID);";
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

            try {
                SimpleStatement cqlQuery = new SimpleStatement(userThreads);
                session.execute(cqlQuery);

            } catch (Exception et) {
                System.out.println("Can't create User Threads " + et);
            }
            /*
            try {
                SimpleStatement cqlQuery = new SimpleStatement(userThreadsIndex);
                session.execute(cqlQuery);

            } catch (Exception et) {
                System.out.println("Can't create User Threads Index" + et);
            }
            System.out.println("" + userThreadsIndex);
                    */
            session.close();
        } catch (Exception ex) {
            System.out.println("Something like major wrong here!");
        }

    }
}
