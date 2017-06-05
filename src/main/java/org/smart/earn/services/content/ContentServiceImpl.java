/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.earn.services.content;

import java.util.List;
import org.smart.earn.dao.content.ContentDao;
import org.smart.earn.model.Contents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abhishek.rajawat
 */
@Service
public class ContentServiceImpl implements ContentService{
    
    @Autowired
    private ContentDao contentDao;
    
    @Override
    public Contents findById(long id){
        return contentDao.findById(id);
    }

    @Override
    public List<Contents> readByTitle(String title) {
        return contentDao.readByTitle(title);
    }

    @Override
    public boolean save(Contents content) {
        return contentDao.save(content);
    }

    @Override
    public boolean update(Contents content) {
        return contentDao.update(content);
    }

    @Override
    public boolean delete(long id) {
        return contentDao.delete(id);
    }
}
