package org.smart.earn.services.property;

import java.util.List;
import org.smart.earn.model.Property;
import org.smart.earn.model.PropertyType;

/**
 *
 * @author abhishek.rajawat
 */
public interface PropertyService {
    
    Property findById(long id);
    
    List<Property> findByName(String name);
    
    List<Property> findByUserId(long userId);
    
    List<PropertyType> findAllPropType();
    
    List<Property> findByType(long type);
    
    List<Property> findByLocation(String city, String state, String country);
    
    List<Property> findAllAvailableProperty();
    
    boolean saveProperty(Property propty);
    
    boolean updateProperty(Property propty);
    
    boolean deleteProperty(long id);
}
