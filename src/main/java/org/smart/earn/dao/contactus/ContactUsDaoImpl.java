/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.dao.contactus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.smart.earn.model.ContactUs;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class ContactUsDaoImpl implements ContactUsDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public boolean save(ContactUs contactUs) {
        try {
            entityManager.merge(contactUs);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ContactUs findById(long id) {
        TypedQuery<ContactUs> query = entityManager.createQuery(
                "SELECT a FROM ContactUs a WHERE a.id = :id", ContactUs.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public ContactUs findByEmail(String email) {
        TypedQuery<ContactUs> query = entityManager.createQuery(
                "SELECT a FROM ContactUs a WHERE a.email = :email", ContactUs.class);
        return query.setParameter("email", email).getSingleResult();
    }
    
}
