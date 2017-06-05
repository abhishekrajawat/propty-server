package org.smart.earn.dao.partybuyer;

import java.util.List;
import org.smart.earn.model.PartyBuyer;

/**
 *
 * @author abhishek.rajawat
 */
public interface PartyBuyerDao {
    
    PartyBuyer findById(long id);
    
    List<PartyBuyer> findByUserId(long id);
    
    List<PartyBuyer> findByPropertyId(long id);
    
    List<PartyBuyer> findByPropertyAndUser(long propertyId, long userId);
    
    boolean save(PartyBuyer buyer);
    
    boolean update(PartyBuyer buyer);
    
}
