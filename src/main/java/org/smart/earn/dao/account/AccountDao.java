package org.smart.earn.dao.account;

import org.smart.earn.model.Account;

/**
 *
 * @author abhishek.rajawat
 */
public interface AccountDao {
 
    Account findById(long id);
    
    Account findByUserId(long id);
    
    boolean save(Account acc);
    
    boolean update(Account acc);
}
