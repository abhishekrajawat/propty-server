package org.smart.earn.services.contactus;

import org.smart.earn.model.ContactUs;

/**
 *
 * @author abhishek.rajawat
 */
public interface ContactUsService {
    
    ContactUs findById(long id);
    
    ContactUs findByEmail(String email);
    
    boolean save(ContactUs contact);
}
