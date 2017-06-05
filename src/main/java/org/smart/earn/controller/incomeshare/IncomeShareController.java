package org.smart.earn.controller.incomeshare;

import java.util.List;
import org.smart.earn.model.IncomeShare;
import org.smart.earn.services.incomeshare.IncomeShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author abhishek.rajawat
 */
@Controller
@RequestMapping("income")
public class IncomeShareController {
    
    @Autowired
    private IncomeShareService incomeShareService;
    
    @GetMapping("share/{propId}/{userId}")
    public ResponseEntity<List<IncomeShare>> getUserById(@PathVariable("propId") Integer propId, 
            @PathVariable("userId") Integer userId) {
        List<IncomeShare> share = incomeShareService.getByUserIdPropId(propId, userId);
        return new ResponseEntity<List<IncomeShare>>(share, HttpStatus.OK);
    }
}
