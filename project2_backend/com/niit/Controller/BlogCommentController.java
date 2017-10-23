package com.niit.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Dao.BlogPostDao;
import com.niit.Dao.UserDao;
import com.niit.Model.BlogComment;
import com.niit.Model.Error;
import com.niit.Model.User;

@Controller
public class BlogCommentController {
	
	
	@Autowired
	private BlogPostDao blogPostDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/addcomment",method=RequestMethod.POST)
	public ResponseEntity<?> addBlogComment(@RequestBody BlogComment blogComment,HttpSession session){
		
		
		if(session.getAttribute("username")==null){ 
			Error error=new Error(5,"Unauthorized access");
			//Error error=new Error(5,"Unauthorized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		String username=(String)session.getAttribute("username");
		User user=userDao.getUserByUsername(username);//commentedBy
		//$scope.blogComment.commentedBy=$scope.user
		blogComment.setCommentedBy(user);
		blogComment.setCommentedOn(new Date());
		System.out.println(blogComment);
		blogPostDao.addBlogComment(blogComment);
		return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
		
		
	}

	@RequestMapping(value="/getblogcomments/{blogPostId}",method=RequestMethod.GET)
	public ResponseEntity<?> getBlogComments(@PathVariable int blogPostId,HttpSession session){
		
		if(session.getAttribute("username")==null){ 
			Error error=new Error(5,"Unauthorized access");
			//Error error=new Error(5,"Unauthorized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}

		List<BlogComment> blogComments=blogPostDao.getBlogComments(blogPostId);
		return new ResponseEntity<List<BlogComment>>(blogComments,HttpStatus.OK);
		
	}
	
	
}
