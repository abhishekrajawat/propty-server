/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.services.userimages;

import org.smart.earn.dao.userimages.UserImagesDao;
import org.smart.earn.model.UserImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class UserImagesServiceImpl implements UserImagesService{
    
    @Autowired
    private UserImagesDao imagesDao;

    @Override
    public boolean save(UserImages image) {
        return imagesDao.save(image);
    }

    @Override
    public boolean delete(long id) {
        return imagesDao.delete(id);
    }
    
    
}
