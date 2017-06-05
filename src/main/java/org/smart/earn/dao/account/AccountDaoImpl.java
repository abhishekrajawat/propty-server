package org.smart.earn.dao.account;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.smart.earn.model.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class AccountDaoImpl implements AccountDao{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Account findById(long id) {
        TypedQuery<Account> query = entityManager.createQuery(
                "SELECT r FROM Account r WHERE r.accountId = :id", Account.class);
        return query.setParameter("id", id).getSingleResult();
    }
    
    @Override
    public Account findByUserId(long id) {
        TypedQuery<Account> query = entityManager.createQuery(
                "SELECT r FROM Account r WHERE r.authUser = :id", Account.class);
        return (Account) query.setParameter("id", id).getResultList();
    }
    
    @Override
    public boolean save(Account acc) {
        try {
            entityManager.merge(acc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean update(Account acc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
