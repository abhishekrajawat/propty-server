package org.smart.earn.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author abhishek.rajawat
 */
@Entity
@Table(name = "CONTACTUS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ContactUs {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    
    @Column(name = "PERSONNAME")
    private String name;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "CONTACT")
    private String phone;
    
    @Column(name = "MESSAGE")
    private String message;
    
    @Column(name = "REG_DATE")
    private Date reg_time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getReg_time() {
        return reg_time;
    }

    public void setReg_time(Date reg_time) {
        this.reg_time = reg_time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    
}
