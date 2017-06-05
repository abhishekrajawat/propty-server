/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.dao.rentalincome;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.smart.earn.model.RentalIncome;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class RentalIncomeDaoImpl implements RentalIncomeDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public RentalIncome findById(long id) {
        TypedQuery<RentalIncome> query = entityManager.createQuery(
                "SELECT r FROM RentalIncome r WHERE r.rentalIncomeId = :id", RentalIncome.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public List<RentalIncome> findByPropertyId(long id) {
        TypedQuery<RentalIncome> query = entityManager.createQuery(
                "SELECT r FROM RentalIncome r WHERE r.property = :id", RentalIncome.class);
        return (List<RentalIncome>)query.setParameter("id", id).getResultList();
    }

    @Override
    public boolean save(RentalIncome income) {
        try {
            entityManager.merge(income);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(RentalIncome income) {
        RentalIncome findincome = new RentalIncome();
        findincome.setAmount(income.getAmount());
        findincome.setBankName(income.getBankName());
        findincome.setCurrency(income.getCurrency());
        findincome.setPaymentStatus(income.getPaymentStatus());
        findincome.setProperty(income.getProperty());
        findincome.setDescription(income.getDescription());
        try{
            entityManager.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
