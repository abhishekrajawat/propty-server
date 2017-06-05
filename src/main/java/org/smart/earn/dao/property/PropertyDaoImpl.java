/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package org.smart.earn.dao.property;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import org.smart.earn.model.Property;
import org.smart.earn.model.PropertyType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class PropertyDaoImpl implements PropertyDao{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Property findById(long id) {
        TypedQuery<Property> query = entityManager.createQuery(
                "SELECT p FROM Property p WHERE p.propertyId = :id", Property.class);
        return query.setParameter("id", id).getSingleResult();
    }
    
    @Override
    public List<PropertyType> findAllPropType() {
        TypedQuery<PropertyType> query = entityManager.createQuery(
                "SELECT p FROM PropertyType p", PropertyType.class);
        return query.getResultList();
    }
    
    @Override
    public List<Property> findByName(String name) {
        TypedQuery<Property> query = entityManager.createQuery(
                "SELECT p FROM Property p WHERE p.propertyName = :name and p.available = :available", Property.class);
        return (List<Property>)query.setParameter("name", name).setParameter("available", "Y").getResultList();
    }
    
    @Override
    public List<Property> findByUserId(long userId) {
        TypedQuery<Property> query = entityManager.createQuery(
                "SELECT p FROM Property p WHERE p.userId = :id and p.available = :available", Property.class);
        return (List<Property>)query.setParameter("id", userId).setParameter("available", "Y").getResultList();
    }
    
    @Override
    public List<Property> findByType(long type) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Property> query = builder.createQuery(Property.class);
        
        Root<Property> property = query.from(Property.class);
        Join<Property, PropertyType> associateJoin = property.join("propertyType");
        TypedQuery<Property> typedQuery = entityManager.createQuery(query
                
                .select(property)
                .where(builder.and(
                        builder.equal(associateJoin.get("propertyTypeId"), type)
                        
                ))
                .orderBy(builder.desc(property.get("regDate")))
        );
        
        return typedQuery.getResultList();
    }
    
    @Override
    public List<Property> findByLocation(String city, String state, String country) {
        TypedQuery<Property> query = entityManager.createQuery(
                "SELECT p FROM Property p WHERE (p.city = :city or p.state = :state or p.country = :country) and p.available = :available", Property.class);
        return (List<Property>)query.setParameter("city", city)
                .setParameter("State", state)
                .setParameter("country", country)
                .setParameter("available", "Y").getResultList();
    }
    
    @Override
    public List<Property> findAllAvailableProperty() {
        TypedQuery<Property> query = entityManager.createQuery(
                "SELECT p FROM Property p WHERE p.available = :available order by regDate desc", Property.class);
        return (List<Property>)query.setParameter("available", "Y").getResultList();
    }
    
    @Override
    public boolean saveProperty(Property propty) {
        try {
            entityManager.merge(propty);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean updateProperty(Property propty) {
        Property findPropty  = new Property();
        findPropty.setUserId(propty.getUserId());
        findPropty.setPropertyName(propty.getPropertyName());
        findPropty.setPropertyType(propty.getPropertyType());
        findPropty.setImages(propty.getImages());
        findPropty.setConstructionArea(propty.getConstructionArea());
        findPropty.setTotalArea(propty.getTotalArea());
        findPropty.setTotalPrice(propty.getTotalPrice());
        findPropty.setUnitPrice(propty.getUnitPrice());
        findPropty.setAvailable(propty.getAvailable());
        findPropty.setUnitsSold(propty.getUnitsSold());
        findPropty.setAddressLine1(propty.getAddressLine1());
        findPropty.setAddressLine2(propty.getAddressLine2());
        findPropty.setCity(propty.getCity());
        findPropty.setState(propty.getState());
        findPropty.setCountry(propty.getCountry());
        findPropty.setPostcode(propty.getPostcode());
        findPropty.setDescription(propty.getDescription());
        try{
            entityManager.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    @Override
    public boolean deleteProperty(long id) {
        Property propty = findById(id);
        propty.setAvailable("N");
        try{
            entityManager.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
