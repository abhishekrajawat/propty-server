package org.smart.earn.dao.incomeshare;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.smart.earn.model.IncomeShare;
import org.smart.earn.model.Property;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class IncomeShareDaoImpl implements IncomeShareDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public IncomeShare read(long id) {
        
        TypedQuery<IncomeShare> query = entityManager.createQuery(
                "SELECT p FROM IncomeShare i WHERE i.incomeShareId = :id", IncomeShare.class);
        return query.setParameter("id", id).getSingleResult();
    }
    
    @Override
    public List<IncomeShare> getByUserIdPropId(long propId, long userId) {
        
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<IncomeShare> query = builder.createQuery(IncomeShare.class);
        
        Root<IncomeShare> income = query.from(IncomeShare.class);
        Join<IncomeShare, Property> property = income.join("property");
        TypedQuery<IncomeShare> typedQuery = entityManager.createQuery(query               
                .select(income)
                .where(builder.and(builder.equal(property.get("propertyId"), propId)), 
                        builder.and(builder.equal(property.get("userId"), userId)))
                .orderBy(builder.desc(property.get("paymentDate"))));
        
        return typedQuery.getResultList();
        
//        TypedQuery<IncomeShare> query = entityManager.createQuery(
//                "SELECT p FROM IncomeShare i WHERE i.incomeShareId = :id", IncomeShare.class);
//        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public boolean save(IncomeShare share) {
        try {
            entityManager.merge(share);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(IncomeShare share) {
        IncomeShare findShare = new IncomeShare();
        findShare.setAmountPerUnit(share.getAmountPerUnit());
        findShare.setBuyerUnits(share.getBuyerUnits());
        findShare.setCurrency(share.getCurrency());
        findShare.setDescription(share.getDescription());
        findShare.setPaymentDate(new Date());
        findShare.setPaymentStaus(share.getPaymentStaus());
        findShare.setProperty(share.getProperty());
        try{
            entityManager.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public List<IncomeShare> listByProperty(long proptyId) {
        TypedQuery<IncomeShare> query = entityManager.createQuery(
                "SELECT p FROM IncomeShare i WHERE i.property = :id", IncomeShare.class);
        return query.setParameter("id", proptyId).getResultList();
    }
    
}
