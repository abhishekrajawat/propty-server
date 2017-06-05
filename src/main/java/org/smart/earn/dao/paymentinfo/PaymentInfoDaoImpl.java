/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.dao.paymentinfo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.smart.earn.model.PartyBuyer;
import org.smart.earn.model.PaymentInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class PaymentInfoDaoImpl implements PaymentInfoDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PaymentInfo findById(long id) {
        TypedQuery<PaymentInfo> query = entityManager.createQuery(
                "SELECT r FROM PaymentInfo r WHERE r.PaymentInfoId = :id", PaymentInfo.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public List<PaymentInfo> findByProperty(long propertyId) {
        TypedQuery<PaymentInfo> query = entityManager.createQuery(
                "SELECT p FROM PaymentInfo p WHERE p.property = :property", PaymentInfo.class);
        return (List<PaymentInfo>)query.setParameter("property", propertyId).getResultList();
    }

    @Override
    public List<PaymentInfo> findByUserId(long userId) {
        TypedQuery<PaymentInfo> query = entityManager.createQuery(
                "SELECT p FROM PaymentInfo p WHERE p.userId = :userId", PaymentInfo.class);
        return (List<PaymentInfo>)query.setParameter("userId", userId).getResultList();
    }

    @Override
    public boolean save(PaymentInfo info) {
        try {
            entityManager.merge(info);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(PaymentInfo info) {
        PaymentInfo setInfo = new PaymentInfo();
        setInfo.setAmount(info.getAmount());
        setInfo.setBankName(info.getBankName());
        setInfo.setCurrency(info.getCurrency());
        setInfo.setNoOfUnits(info.getNoOfUnits());
        setInfo.setPaymentStatus(info.getPaymentStatus());
        setInfo.setProperty(info.getProperty());
        setInfo.setUserId(info.getUserId());
        try{
            entityManager.flush();
            return true;
        }catch(Exception e){
            return false;
        }
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
    	PartyBuyer party = new PartyBuyer();
    	
    	party.setCurrency(buyer.getCurrency());
    	party.setDescription(buyer.getDescription());
    	party.setNoOfUnits(buyer.getNoOfUnits());
    	party.setProperty(buyer.getProperty());
    	party.setUserId(buyer.getUserId());
    	
        try{
            entityManager.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
