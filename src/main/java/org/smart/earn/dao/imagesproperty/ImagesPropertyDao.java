package org.smart.earn.dao.imagesproperty;

import org.smart.earn.model.ImagesProperty;

/**
 *
 * @author abhishek.rajawat
 */
public interface ImagesPropertyDao {
    
    boolean save(ImagesProperty image);
    
    boolean delete(ImagesProperty image);
    
}
