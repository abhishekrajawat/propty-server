package org.smart.earn.dao.partyseller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.smart.earn.model.PartySeller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class PartySellerDaoImpl implements PartySellerDao{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public PartySeller findById(long id) {
        TypedQuery<PartySeller> query = entityManager.createQuery(
                "SELECT p FROM PartySeller p WHERE p.partySellerId = :id", PartySeller.class);
        return query.setParameter("id", id).getSingleResult();
    }
    
    @Override
    public List<PartySeller> findByUserId(long id) {
        TypedQuery<PartySeller> query = entityManager.createQuery(
                "SELECT p FROM PartySeller p WHERE p.userId = :id", PartySeller.class);
        return (List<PartySeller>)query.setParameter("id", id).getResultList();
    }
    
    @Override
    public List<PartySeller> findByPropertyId(long id) {
        TypedQuery<PartySeller> query = entityManager.createQuery(
                "SELECT p FROM PartySeller p WHERE p.property = :id", PartySeller.class);
        return (List<PartySeller>)query.setParameter("id", id).getResultList();
    }
    
    @Override
    public List<PartySeller> findByPropertyAndUser(long propertyId, long userId) {
        TypedQuery<PartySeller> query = entityManager.createQuery(
                "SELECT p FROM PartySeller p WHERE p.property = :ProptyId and p.userId = :userId", PartySeller.class);
        return (List<PartySeller>)query.setParameter("ProptyId", propertyId)
                .setParameter("userId", userId).getResultList();
    }
    
    @Override
    public boolean save(PartySeller seller) {
        try {
            entityManager.merge(seller);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean update(PartySeller seller) {
        PartySeller findSeller = new PartySeller();
        findSeller.setDescription(seller.getDescription());
        findSeller.setProperty(seller.getProperty());
        findSeller.setUserId(seller.getUserId());
        try{
            entityManager.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
