package org.smart.earn.dao.contactus;

import org.smart.earn.model.ContactUs;

/**
 *
 * @author abhishek.rajawat
 */
public interface ContactUsDao {
    
    ContactUs findById(long id);
    
    ContactUs findByEmail(String email);
    
    boolean save(ContactUs contactUs);
}
