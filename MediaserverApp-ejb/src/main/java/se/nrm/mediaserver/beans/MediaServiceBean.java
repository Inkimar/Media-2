/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.mediaserver.beans;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.nrm.mediaserver.domain.MediaService;

/**
 *
 * @author ingimar
 */
@Stateless
public class MediaServiceBean implements MediaService {
    
    @PersistenceContext(unitName = "MysqlStatesPU")
    private EntityManager em;

    @Override
    public void save(Object media) {
        em.persist(media);
    }

    @Override
    public String test() {
        return this.getClass().getCanonicalName();
    }
}
