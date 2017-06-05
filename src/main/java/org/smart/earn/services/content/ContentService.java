/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.services.content;

import java.util.List;
import org.smart.earn.model.Contents;

/**
 *
 * @author abhishek.rajawat
 */
public interface ContentService {
    
    Contents findById(long id);
    
    List<Contents> readByTitle(String title);
    
    boolean save(Contents content);
    
    boolean update(Contents content);
    
    boolean delete(long id);
}
