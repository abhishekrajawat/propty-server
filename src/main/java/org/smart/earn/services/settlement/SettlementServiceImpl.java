/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.services.settlement;

import java.util.List;
import org.smart.earn.dao.settlement.SettlementDao;
import org.smart.earn.model.Settlement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class SettlementServiceImpl implements SettlementService{
    
    @Autowired
    private SettlementDao settlementDao;

    @Override
    public Settlement findById(long id) {
        return settlementDao.findById(id);
    }

    @Override
    public List<Settlement> findByProperty(long propertyId) {
        return settlementDao.findByProperty(propertyId);
    }

    @Override
    public List<Settlement> findByPaymentInfo(long paymentInfo) {
        return settlementDao.findByPaymentInfo(paymentInfo);
    }

    @Override
    public boolean save(Settlement settlement) {
        return settlementDao.save(settlement);
    }

    @Override
    public boolean update(Settlement settlement) {
        return settlementDao.update(settlement);
    }
      
}
