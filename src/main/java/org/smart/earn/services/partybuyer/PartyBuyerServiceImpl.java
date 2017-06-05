package org.smart.earn.services.partybuyer;

import java.util.List;
import org.smart.earn.dao.partybuyer.PartyBuyerDao;
import org.smart.earn.model.PartyBuyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class PartyBuyerServiceImpl implements PartyBuyerService{
    
    @Autowired
    private PartyBuyerDao partyBuyerDao;

    @Override
    public PartyBuyer findById(long id) {
        return partyBuyerDao.findById(id);
    }

    @Override
    public List<PartyBuyer> findByUserId(long id) {
        return partyBuyerDao.findByUserId(id);
    }

    @Override
    public List<PartyBuyer> findByPropertyId(long id) {
        return partyBuyerDao.findByPropertyId(id);
    }

    @Override
    public List<PartyBuyer> findByPropertyAndUser(long propertyId, long userId) {
        return partyBuyerDao.findByPropertyAndUser(propertyId, userId);
    }

    @Override
    public boolean save(PartyBuyer buyer) {
        return partyBuyerDao.save(buyer);
    }

    @Override
    public boolean update(PartyBuyer buyer) {
        return partyBuyerDao.update(buyer);
    }
}
