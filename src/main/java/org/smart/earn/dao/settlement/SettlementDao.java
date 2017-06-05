/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.dao.settlement;

import java.util.List;
import org.smart.earn.model.Settlement;

/**
 *
 * @author abhishek.rajawat
 */
public interface SettlementDao {
    
    Settlement findById(long id);
    
    List<Settlement> findByProperty(long propertyId);
    
    List<Settlement> findByPaymentInfo(long paymentInfo);
    
    boolean save(Settlement settlement);
    
    boolean update(Settlement settlement);
    
}
