package org.smart.earn.services.incomeshare;

import java.util.List;
import org.smart.earn.dao.incomeshare.IncomeShareDao;
import org.smart.earn.model.IncomeShare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class IncomeShareServiceImpl implements IncomeShareService{
    
    @Autowired
    private IncomeShareDao incomeShareDao;

    @Override
    public IncomeShare read(long id) {
        return incomeShareDao.read(id);
    }
    
    @Override
    public List<IncomeShare> getByUserIdPropId(long propId, long userId) {
        return incomeShareDao.getByUserIdPropId(propId, userId);
    }

    @Override
    public boolean save(IncomeShare share) {
        return incomeShareDao.save(share);
    }

    @Override
    public boolean update(IncomeShare share) {
        return incomeShareDao.update(share);
    }

    @Override
    public List<IncomeShare> listByProperty(long proptyId) {
        return incomeShareDao.listByProperty(proptyId);
    }
    
    
}
