/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.dao.settlement;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.smart.earn.model.Settlement;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class SettlementDaoImpl implements SettlementDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Settlement findById(long id) {
        TypedQuery<Settlement> query = entityManager.createQuery(
                "SELECT p FROM Settlement p WHERE p.settlementId = :id", Settlement.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Settlement> findByProperty(long propertyId) {
        TypedQuery<Settlement> query = entityManager.createQuery(
                "SELECT p FROM Settlement p WHERE p.property = :property", Settlement.class);
        return (List<Settlement>)query.setParameter("property", propertyId).getResultList();
    }

    @Override
    public List<Settlement> findByPaymentInfo(long paymentInfo) {
        TypedQuery<Settlement> query = entityManager.createQuery(
                "SELECT p FROM Settlement p WHERE p.paymentInfo = :paymentInfo", Settlement.class);
        return (List<Settlement>)query.setParameter("paymentInfo", paymentInfo).getResultList();
    }

    @Override
    public boolean save(Settlement settlement) {
        try {
            entityManager.merge(settlement);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Settlement settlement) {
        Settlement setSettlement = new Settlement();
        setSettlement.setAmount(settlement.getAmount());
        setSettlement.setCommission(settlement.getCommission());
        setSettlement.setCurrency(settlement.getCurrency());
        setSettlement.setNoOfUnits(settlement.getNoOfUnits());
        setSettlement.setProperty(settlement.getProperty());
        try{
            entityManager.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
