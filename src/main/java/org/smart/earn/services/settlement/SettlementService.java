package org.smart.earn.services.settlement;

import java.util.List;
import org.smart.earn.model.Settlement;

/**
 *
 * @author abhishek.rajawat
 */
public interface SettlementService {
    
    Settlement findById(long id);
    
    List<Settlement> findByProperty(long propertyId);
    
    List<Settlement> findByPaymentInfo(long paymentInfo);
    
    boolean save(Settlement settlement);
    
    boolean update(Settlement settlement);
}
