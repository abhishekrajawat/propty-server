package org.smart.earn.services.incomeshare;

import java.util.List;
import org.smart.earn.model.IncomeShare;

/**
 *
 * @author abhishek.rajawat
 */
public interface IncomeShareService {
    
    IncomeShare read(long id);
    
    List<IncomeShare> getByUserIdPropId(long propId, long userId);
    
    boolean save(IncomeShare share);
    
    boolean update(IncomeShare share);
    
    List<IncomeShare> listByProperty(long proptyId);
}
