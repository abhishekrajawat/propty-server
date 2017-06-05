package org.smart.earn.dao.content;

import java.util.List;
import org.smart.earn.model.Contents;

/**
 *
 * @author abhishek.rajawat
 */
public interface ContentDao {
    
    Contents findById(long id);
    
    List<Contents> readByTitle(String title);
    
    boolean save(Contents content);
    
    boolean update(Contents content);
    
    boolean delete(long id);
    
}
