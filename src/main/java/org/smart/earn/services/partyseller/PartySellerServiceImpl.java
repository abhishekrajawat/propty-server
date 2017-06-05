package org.smart.earn.services.partyseller;

import java.util.List;
import org.smart.earn.dao.partyseller.PartySellerDao;
import org.smart.earn.model.PartySeller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class PartySellerServiceImpl implements PartySellerService{
    
    @Autowired
    private PartySellerDao partySellerDao;
    
    @Override
    public PartySeller findById(long id) {
        return partySellerDao.findById(id);
    }
    
    @Override
    public List<PartySeller> findByUserId(long id) {
        return partySellerDao.findByUserId(id);
    }
    
    @Override
    public List<PartySeller> findByPropertyId(long id) {
        return partySellerDao.findByPropertyId(id);
    }
    
    @Override
    public List<PartySeller> findByPropertyAndUser(long propertyId, long userId) {
        return partySellerDao.findByPropertyAndUser(propertyId, userId);
    }
    
    @Override
    public boolean save(PartySeller seller) {
        return partySellerDao.save(seller);
    }
    
    @Override
    public boolean update(PartySeller seller) {
        return partySellerDao.update(seller);
    }
}
