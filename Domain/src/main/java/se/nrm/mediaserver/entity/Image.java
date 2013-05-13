/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.mediaserver.entity;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author ingimar
 */
@Entity
public class Image extends Media implements Serializable {

    private static final long serialVersionUID = 1L;

    public Image() {
    }
   
    
}
