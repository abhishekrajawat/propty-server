/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.dao.property;

import java.util.List;
import org.smart.earn.model.Property;
import org.smart.earn.model.PropertyType;

/**
 *
 * @author abhishek.rajawat
 */
public interface PropertyDao {
    
    Property findById(long id);
    
    List<PropertyType> findAllPropType();
    
    List<Property> findByName(String name);
    
    List<Property> findByUserId(long userId);
    
    List<Property> findByType(long type);
    
    List<Property> findByLocation(String city, String state, String country);
    
    List<Property> findAllAvailableProperty();
    
    boolean saveProperty(Property propty);
    
    boolean updateProperty(Property propty);
    
    boolean deleteProperty(long id);
}
