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

    private static MediaService fetchBean() throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.setProperty("org.omg.CORBA.ORBInitialHost", "172.16.34.31"); // 172.16.34.31 , 192.168.10.163 , 127.0.0.1
        Context ctx = new InitialContext(jndiProps);
        MediaService bean = (MediaService) ctx.lookup("java:global/MediaserverApp-ejb/MediaServiceBean");
        return bean;
    }
}
