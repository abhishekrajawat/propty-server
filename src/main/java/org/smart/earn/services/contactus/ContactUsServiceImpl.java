package org.smart.earn.services.contactus;

import org.smart.earn.dao.contactus.ContactUsDao;
import org.smart.earn.model.ContactUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class ContactUsServiceImpl implements ContactUsService{
    
    @Autowired
    private ContactUsDao contactDao;

    @Override
    public boolean save(ContactUs contact) {
        return contactDao.save(contact);
    }

    @Override
    public ContactUs findById(long id) {
        return contactDao.findById(id);
    }

    @Override
    public ContactUs findByEmail(String email) {
        return contactDao.findByEmail(email);
    }
}
