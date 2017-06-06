package org.smart.earn.controller.content;

import java.util.List;

import org.smart.earn.model.Contents;
import org.smart.earn.services.content.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author abhishek.rajawat
 */
@Controller
@RequestMapping("content")
public class ContentController {
    
    @Autowired
    private ContentService contentService;
    
    @GetMapping("contentid/{id}")
    public ResponseEntity<Contents> getByTitle(@PathVariable("id") long id){
        Contents content = contentService.findById(id);
        return new ResponseEntity<Contents>(content, HttpStatus.OK);
    }
    
    @GetMapping("content/{title}")
    public ResponseEntity<List<Contents>> getByTitle(@PathVariable("title") String title){
        List<Contents> content = contentService.readByTitle(title);
        return new ResponseEntity<List<Contents>>(content, HttpStatus.OK);
    }
    
    @PostMapping("addcontent")
    public ResponseEntity<Void> addContent(@RequestBody Contents content, UriComponentsBuilder builder){
        try{
            contentService.save(content);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/content/{id}").buildAndExpand(content.getContentId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PutMapping("updatecontent")
    public ResponseEntity<Contents> updateContent(@RequestBody Contents content){
        contentService.update(content);
        return new ResponseEntity<Contents>(content, HttpStatus.OK);
    }
    
    @DeleteMapping("delcontent/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		contentService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
