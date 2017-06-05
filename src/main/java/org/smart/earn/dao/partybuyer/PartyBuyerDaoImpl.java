package org.smart.earn.dao.partybuyer;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.smart.earn.model.PartyBuyer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class PartyBuyerDaoImpl implements PartyBuyerDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public PartyBuyer findById(long id) {
        TypedQuery<PartyBuyer> query = entityManager.createQuery(
                "SELECT p FROM PartyBuyer p WHERE p.partyBuyerId = :id", PartyBuyer.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public List<PartyBuyer> findByUserId(long id) {
        TypedQuery<PartyBuyer> query = entityManager.createQuery(
                "SELECT p FROM PartyBuyer p WHERE p.userId = :id", PartyBuyer.class);
        return (List<PartyBuyer>)query.setParameter("id", id).getResultList();
    }

    @Override
    public List<PartyBuyer> findByPropertyId(long id) {
        TypedQuery<PartyBuyer> query = entityManager.createQuery(
                "SELECT p FROM PartyBuyer p WHERE p.property = :id", PartyBuyer.class);
        return (List<PartyBuyer>)query.setParameter("id", id).getResultList();
    }

    @Override
    public List<PartyBuyer> findByPropertyAndUser(long propertyId, long userId){
        TypedQuery<PartyBuyer> query = entityManager.createQuery(
                "SELECT p FROM PartyBuyer p WHERE p.property = :ProptyId and p.userId = :userId", PartyBuyer.class);
        return (List<PartyBuyer>)query.setParameter("ProptyId", propertyId)
                .setParameter("userId", userId).getResultList();
    }
    
    @Override
    public boolean save(PartyBuyer buyer) {
        try {
            entityManager.merge(buyer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(PartyBuyer buyer) {
        PartyBuyer findBuyer = new PartyBuyer();
        findBuyer.setCurrency(buyer.getCurrency());
        findBuyer.setNoOfUnits(buyer.getNoOfUnits());
        findBuyer.setDescription(buyer.getDescription());
        findBuyer.setProperty(buyer.getProperty());
        findBuyer.setUserId(buyer.getUserId());
        try{
            entityManager.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
