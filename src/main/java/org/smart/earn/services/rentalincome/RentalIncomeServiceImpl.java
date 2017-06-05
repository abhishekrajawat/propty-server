package org.smart.earn.services.rentalincome;

import java.util.List;
import org.smart.earn.dao.rentalincome.RentalIncomeDao;
import org.smart.earn.model.RentalIncome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class RentalIncomeServiceImpl implements RentalIncomeService{
    
    @Autowired
    private RentalIncomeDao incomeDao;

    @Override
    public RentalIncome findById(long id) {
        return incomeDao.findById(id);
    }

    @Override
    public List<RentalIncome> findByPropertyId(long id) {
        return incomeDao.findByPropertyId(id);
    }

    @Override
    public boolean save(RentalIncome income) {
        return incomeDao.save(income);
    }

    @Override
    public boolean update(RentalIncome income) {
        return incomeDao.update(income);
    }
       
}
