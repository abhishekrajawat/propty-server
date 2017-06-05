package org.smart.earn.services.partyseller;

import java.util.List;
import org.smart.earn.model.PartySeller;

/**
 *
 * @author abhishek.rajawat
 */
public interface PartySellerService {
    
    PartySeller findById(long id);
    
    List<PartySeller> findByUserId(long id);
    
    List<PartySeller> findByPropertyId(long id);
    
    List<PartySeller> findByPropertyAndUser(long propertyId, long userId);
    
    boolean save(PartySeller seller);
    
    boolean update(PartySeller seller);
}
