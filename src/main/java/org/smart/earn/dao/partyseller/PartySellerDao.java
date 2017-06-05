package org.smart.earn.dao.partyseller;

import java.util.List;
import org.smart.earn.model.PartySeller;

/**
 *
 * @author abhishek.rajawat
 */
public interface PartySellerDao {
    
    PartySeller findById(long id);
    
    List<PartySeller> findByUserId(long id);
    
    List<PartySeller> findByPropertyId(long id);
    
    List<PartySeller> findByPropertyAndUser(long propertyId, long userId);
    
    boolean save(PartySeller seller);
    
    boolean update(PartySeller seller);
}
