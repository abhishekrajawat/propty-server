/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.controller.property;

import java.util.List;
import org.smart.earn.model.Property;
import org.smart.earn.model.PropertyType;
import org.smart.earn.services.property.PropertyService;
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
@RequestMapping("property")
public class PropertyController {
    
    @Autowired
    private PropertyService proptyService;
    
    @GetMapping("allprop")
    public ResponseEntity<List<Property>> getAllProp(){
        List<Property> prop = proptyService.findAllAvailableProperty();
        return new ResponseEntity<List<Property>>(prop, HttpStatus.OK);
    }
    
    @GetMapping("allproptype")
    public ResponseEntity<List<PropertyType>> getPropType(){
        List<PropertyType> prop = proptyService.findAllPropType();
        return new ResponseEntity<List<PropertyType>>(prop, HttpStatus.OK);
    }
    
    @GetMapping("propties/{type}")
    public ResponseEntity<List<Property>> getByType(@PathVariable("type") long type){
        List<Property> property = proptyService.findByType(type);
        return new ResponseEntity<List<Property>>(property, HttpStatus.OK);
    }
    
    @GetMapping("proptybyuser/{userId}")
    public ResponseEntity<List<Property>> getByUserId(@PathVariable("userId") long userId){
        List<Property> property = proptyService.findByUserId(userId);
        return new ResponseEntity<List<Property>>(property, HttpStatus.OK);
    }
    
    @GetMapping("property/{id}")
    public ResponseEntity<Property> getById(@PathVariable("id") long id){
        Property property = proptyService.findById(id);
        return new ResponseEntity<Property>(property, HttpStatus.OK);
    }
    
    @PostMapping("addprop")
    public ResponseEntity<Void> addProperty(@RequestBody Property prop, UriComponentsBuilder builder) {
        try{
            proptyService.saveProperty(prop);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("property/{id}").buildAndExpand(prop.getPropertyId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("updateprop")
    public ResponseEntity<Property> updateUser(@RequestBody Property prop) {
        try{
            proptyService.updateProperty(prop);
            return new ResponseEntity<Property>(prop, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<Property>(HttpStatus.BAD_REQUEST);
        }
    }
}
