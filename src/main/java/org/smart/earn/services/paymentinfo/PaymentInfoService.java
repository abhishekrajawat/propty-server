package org.smart.earn.services.paymentinfo;

import java.util.List;
import org.smart.earn.model.PaymentInfo;

/**
 *
 * @author abhishek.rajawat
 */
public interface PaymentInfoService {
    
    PaymentInfo findById(long id);
    
    List<PaymentInfo> findByProperty(long propertyId);
    
    List<PaymentInfo> findByUserId(long userId);
    
    boolean save(PaymentInfo info);
    
    boolean update(PaymentInfo info);
}
