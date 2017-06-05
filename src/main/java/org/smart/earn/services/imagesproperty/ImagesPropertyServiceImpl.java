package org.smart.earn.services.imagesproperty;

import org.smart.earn.dao.imagesproperty.ImagesPropertyDao;
import org.smart.earn.model.ImagesProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class ImagesPropertyServiceImpl implements ImagesPropertyService{
    
    @Autowired
    private ImagesPropertyDao authUserDao;

    @Override
    public boolean save(ImagesProperty image) {
        return authUserDao.save(image);
    }

    @Override
    public boolean delete(ImagesProperty image) {
        return authUserDao.delete(image);
    }
    
    
}
