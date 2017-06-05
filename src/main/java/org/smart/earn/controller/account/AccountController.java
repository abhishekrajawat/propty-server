package org.smart.earn.controller.account;

import org.smart.earn.model.Account;
import org.smart.earn.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author abhishek.rajawat
 */
@Controller
@RequestMapping("account")
public class AccountController {
    
    @Autowired
    AccountService accService;
    
    @GetMapping("acc/{id}")
    public ResponseEntity<Account> getUserById(@PathVariable("id") Integer id) {
        Account account = accService.findById(id);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }
    
    @GetMapping("useracc/{id}")
    public ResponseEntity<Account> getUserUserId(@PathVariable("id") Integer id) {
        Account account = accService.findByUserId(id);
        return new ResponseEntity<Account>(account, HttpStatus.OK);
    }
    
    @PostMapping("addacc")
    public ResponseEntity<Void> addAccount(@RequestBody Account acc, UriComponentsBuilder builder) {
        boolean flag = accService.save(acc);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/acc/{id}").buildAndExpand(acc.getAccountId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @PutMapping("updateacc")
    public ResponseEntity<Account> updateAcc(@RequestBody Account acc){
        try{
            accService.update(acc);
            return new ResponseEntity<Account>(acc, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Account>(HttpStatus.BAD_REQUEST);
        }
    }
}
