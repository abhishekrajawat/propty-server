package org.smart.earn.services.account;

import org.smart.earn.dao.account.AccountDao;
import org.smart.earn.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findById(long id) {
        return accountDao.findById(id);
    }

    @Override
    public Account findByUserId(long id) {
        return accountDao.findByUserId(id);
    }

    @Override
    public boolean save(Account acc) {
        return accountDao.save(acc);
    }

    @Override
    public boolean update(Account acc) {
        return accountDao.update(acc);
    }
    
    
}
