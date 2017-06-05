package org.smart.earn.dao.content;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.smart.earn.model.Contents;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abhishek.rajawat
 */
@Transactional
@Repository
public class ContentDaoImpl implements ContentDao{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Contents findById(long id){
        TypedQuery<Contents> query = entityManager.createQuery(
                "SELECT p FROM Contents p WHERE p.contentId = :id", Contents.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Contents> readByTitle(String title) {
        TypedQuery<Contents> query = entityManager.createQuery(
                "SELECT p FROM Contents p WHERE p.pageTitle = :title", Contents.class);
        return (List<Contents>)query.setParameter("title", title).getResultList();
    }

    @Override
    public boolean save(Contents content) {
        try {
            entityManager.merge(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Contents content) {
        Contents setContent = new Contents();
        setContent.setPageTitle(content.getPageTitle());
        setContent.setContent(content.getContent());
        setContent.setPageSubSubTitle(content.getPageSubSubTitle());
        setContent.setPageSubTitle(content.getPageSubTitle());
        setContent.setRemarks(content.getRemarks());
        try{
            entityManager.flush();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            entityManager.remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
}
