package org.smart.earn.services.imagesproperty;

import org.smart.earn.model.ImagesProperty;

/**
 *
 * @author abhishek.rajawat
 */
public interface ImagesPropertyService {
    
    boolean save(ImagesProperty image);
    
    boolean delete(ImagesProperty image);
    
}
