package org.smart.earn.dao.paymentinfo;

import java.util.List;

import org.smart.earn.model.PartyBuyer;
import org.smart.earn.model.PaymentInfo;

/**
 *
 * @author abhishek.rajawat
 */
public interface PaymentInfoDao {
    
    PaymentInfo findById(long id);
    
    List<PaymentInfo> findByProperty(long propertyId);
    
    List<PaymentInfo> findByUserId(long userId);
    
    boolean save(PaymentInfo info);
    
    boolean update(PaymentInfo info);
    
    boolean save(PartyBuyer buyer);
    
    boolean update(PartyBuyer buyer);
    
}
