package org.smart.earn.services.property;

import java.util.List;
import org.smart.earn.dao.property.PropertyDao;
import org.smart.earn.model.Property;
import org.smart.earn.model.PropertyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class PropertyServiceImpl implements PropertyService{
    
    @Autowired
    private PropertyDao propertyDao;

    @Override
    public Property findById(long id) {
        return propertyDao.findById(id);
    }
    
    @Override
    public List<PropertyType> findAllPropType(){
      return propertyDao.findAllPropType();
    }

    @Override
    public List<Property> findByName(String name) {
        return propertyDao.findByName(name);
    }
    
    @Override
    public List<Property> findByUserId(long userId) {
        return propertyDao.findByUserId(userId);
    }
    
    @Override
    public List<Property> findByType(long type) {
        return propertyDao.findByType(type);
    }

    @Override
    public List<Property> findByLocation(String city, String state, String country) {
        return propertyDao.findByLocation(city, state, country);
    }

    @Override
    public List<Property> findAllAvailableProperty() {
        return propertyDao.findAllAvailableProperty();
    }

    @Override
    public boolean saveProperty(Property propty) {
        return propertyDao.saveProperty(propty);
    }

    @Override
    public boolean updateProperty(Property propty) {
        return propertyDao.updateProperty(propty);
    }

    @Override
    public boolean deleteProperty(long id) {
        return propertyDao.deleteProperty(id);
    }
    
    
}
