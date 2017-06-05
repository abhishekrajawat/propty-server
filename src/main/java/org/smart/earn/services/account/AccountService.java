package org.smart.earn.services.account;

import org.smart.earn.model.Account;

/**
 *
 * @author abhishek.rajawat
 */
public interface AccountService {
    
    Account findById(long id);
    
    Account findByUserId(long id);
    
    boolean save(Account acc);
    
    /**
     *
     * @param acc
     * @return
     */
    boolean update(Account acc);
    
}
