/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.mediaserver.util;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import se.nrm.mediaserver.domain.MediaService;

/**
 *
 * @author ingimar
 */
public class BeanService {
    public static MediaService getBean(){
         MediaService bean = null;
        try {
            Properties jndiProps = new Properties();
            jndiProps.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.10.139"); // 192.168.10.139 , 172.16.34.31
            Context ctx = new InitialContext(jndiProps);
            //   bean = (MediaService) ctx.lookup("java:global/MediaserverApp-ejb/MediaServiceBean"); // 
            bean = (MediaService) ctx.lookup("java:global/MediaserverApp-ejb/MediaServiceBean!se.nrm.mediaserver.domain.MediaService");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
