/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.mediaserver.domain;

import javax.ejb.Remote;

/**
 *
 * @author ingimar
 */
@Remote
public interface MediaService {

    void save(Object media);
    String test();
    
}
