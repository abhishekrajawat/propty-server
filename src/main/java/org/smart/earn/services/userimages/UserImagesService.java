/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.services.userimages;

import org.smart.earn.model.UserImages;

/**
 *
 * @author abhishek.rajawat
 */
public interface UserImagesService {
    
    boolean save(UserImages image);
    
    boolean delete(long image);
}
