package org.smart.earn.services.paymentinfo;

import java.util.List;
import org.smart.earn.dao.paymentinfo.PaymentInfoDao;
import org.smart.earn.model.PaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class PaymentInfoServiceImpl implements PaymentInfoService{
    
    @Autowired
    private PaymentInfoDao paymentInfoDao;

    @Override
    public PaymentInfo findById(long id) {
        return paymentInfoDao.findById(id);
    }

    @Override
    public List<PaymentInfo> findByProperty(long propertyId) {
        return paymentInfoDao.findByProperty(propertyId);
    }

    @Override
    public List<PaymentInfo> findByUserId(long userId) {
        return paymentInfoDao.findByUserId(userId);
    }

    @Override
    public boolean save(PaymentInfo info) {
        return paymentInfoDao.save(info);
    }

    @Override
    public boolean update(PaymentInfo info) {
        return paymentInfoDao.update(info);
    }
}
