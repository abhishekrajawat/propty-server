/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.dao.userimages;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.smart.earn.model.UserImages;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class UserImagesDaoImpl implements UserImagesDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(UserImages image) {
        try {
            entityManager.merge(image);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            entityManager.remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }  
}
