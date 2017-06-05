package org.smart.earn.dao.imagesproperty;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.smart.earn.model.ImagesProperty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class ImagesPropertyDaoImpl implements ImagesPropertyDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean save(ImagesProperty image) {
        try {
            entityManager.merge(image);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(ImagesProperty image) {
        try {
            entityManager.remove(image);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
