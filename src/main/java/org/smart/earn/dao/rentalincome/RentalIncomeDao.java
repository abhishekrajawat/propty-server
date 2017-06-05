/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.dao.rentalincome;

import java.util.List;
import org.smart.earn.model.RentalIncome;

/**
 *
 * @author abhishek.rajawat
 */
public interface RentalIncomeDao {
    
    RentalIncome findById(long id);
    
    List<RentalIncome> findByPropertyId(long id);
    
    boolean save(RentalIncome income);
    
    boolean update(RentalIncome income);
}
