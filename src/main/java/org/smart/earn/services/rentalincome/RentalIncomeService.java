package org.smart.earn.services.rentalincome;

import java.util.List;
import org.smart.earn.model.RentalIncome;

/**
 *
 * @author abhishek.rajawat
 */
public interface RentalIncomeService {
    
    RentalIncome findById(long id);
    
    List<RentalIncome> findByPropertyId(long id);
    
    boolean save(RentalIncome income);
    
    boolean update(RentalIncome income);
}
