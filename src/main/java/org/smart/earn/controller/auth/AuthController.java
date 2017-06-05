package org.smart.earn.controller.auth;

import java.util.List;

import org.smart.earn.model.AuthUser;
import org.smart.earn.services.auth.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("authuser")
public class AuthController {
    
    @Autowired
    private AuthorizationService authService;
    
    @GetMapping("user/{id}")
    public ResponseEntity<AuthUser> getUserById(@PathVariable("id") Integer id) {
        AuthUser user = authService.findById(id);
        return new ResponseEntity<AuthUser>(user, HttpStatus.OK);
    }
    
    @GetMapping("userbyname/{username:.+}")
    public ResponseEntity<AuthUser> getUserByUsername(@PathVariable("username") String username) {
        try{
            AuthUser user = authService.findByUsername(username);
            return new ResponseEntity<AuthUser>(user, HttpStatus.OK);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<AuthUser>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("users/{mobileno}/{email}")
    public ResponseEntity<List<AuthUser>> getUserByEmailMobileNo(@PathVariable("mobileno") String mobileNo,
            @PathVariable("email") String email) {
        try{
            List<AuthUser> user = (List<AuthUser>) authService.findByEmailMobileNo(mobileNo, email);
            return new ResponseEntity<List<AuthUser>>(user, HttpStatus.OK);
        } catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<List<AuthUser>>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("allusers")
    public ResponseEntity<List<AuthUser>> getAllUser() {
        List<AuthUser> list = authService.findAllUsers();
        return new ResponseEntity<List<AuthUser>>(list, HttpStatus.OK);
    }
    
    @PostMapping("adduser")
    public ResponseEntity<Void> addUser(@RequestBody AuthUser user, UriComponentsBuilder builder) {
        if (authService.isUserExist(user)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        try{
            authService.saveUser(user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("updateuser/{userid}")
    public ResponseEntity<AuthUser> updateUser(@PathVariable("userid") long userId, @RequestBody AuthUser user) {
        try{
        	System.out.println(".................................... Inside controller " +user.getUserId());
            authService.updateUser(user);
            return new ResponseEntity<AuthUser>(user, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<AuthUser>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("deleteuser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        authService.deleteUserById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}