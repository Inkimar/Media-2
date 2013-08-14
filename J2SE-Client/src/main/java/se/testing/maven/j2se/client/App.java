package se.testing.maven.j2se.client;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import se.nrm.mediaserver.domain.MediaService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Start 15:04: Hej världen!");
        try {

            MediaService bean = fetchBean();
            System.out.println("Response coming from bean :->" + bean.test()+"<-");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("END: Hej världen!");
    }

    /**
     * https://forums.oracle.com/thread/2205656
     * Fails on Windows :
     * - using Glassfish 3.1.2.2
     * @return
     * @throws NamingException 
     */
    private static MediaService fetchBean() throws NamingException {
        Properties jndiProps = new Properties();
        String ipAtHome = " 192.168.10.163";
        jndiProps.setProperty("org.omg.CORBA.ORBInitialHost", ipAtHome); // 172.16.34.31 , 192.168.10.163 , 127.0.0.1
        Context ctx = new InitialContext(jndiProps);
        String name="java:global/se.nrm.mediaserver_MediaserverApp-ejb_ejb_1.0-SNAPSHOT/MediaServiceBean!se.nrm.mediaserver.domain.MediaService";
        String shortName="java:global/se.nrm.mediaserver_MediaserverApp-ejb_ejb_1.0-SNAPSHOT/MediaServiceBean";
        String orgName="java:global/MediaserverApp-ejb/MediaServiceBean";
        MediaService bean = (MediaService) ctx.lookup(name);
        return bean;
    }
}
