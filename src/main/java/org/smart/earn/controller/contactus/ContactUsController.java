package org.smart.earn.controller.contactus;

import org.smart.earn.model.ContactUs;
import org.smart.earn.services.contactus.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author abhishek.rajawat
 */
@Controller
@RequestMapping("contactus")
public class ContactUsController {
    
    @Autowired
    private ContactUsService contactUsService;
    
    @GetMapping("contact/{id}")
    public ResponseEntity<ContactUs> getByTitle(@PathVariable("id") long id){
        ContactUs content = contactUsService.findById(id);
        return new ResponseEntity<ContactUs>(content, HttpStatus.OK);
    }
    
    @GetMapping("contactemail/{id}")
    public ResponseEntity<ContactUs> getByEmail(@PathVariable("email") String email){
        ContactUs content = contactUsService.findByEmail(email);
        return new ResponseEntity<ContactUs>(content, HttpStatus.OK);
    }
    
    @PostMapping("savecontactus")
    public ResponseEntity<Void> addContent(@RequestBody ContactUs contact, UriComponentsBuilder builder){
        try{
            contactUsService.save(contact);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/contact/{id}").buildAndExpand(contact.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
}
