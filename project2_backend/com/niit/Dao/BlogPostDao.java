package com.niit.Dao;

import java.util.List;

import com.niit.Model.BlogComment;
import com.niit.Model.BlogPost;

public interface BlogPostDao {
void saveBlogPost(BlogPost blogPost);
List<BlogPost> getAllBlogs(int approved);
BlogPost getBlogPost(int id);
void updateBlogPost(BlogPost blogPost);
List<BlogPost> getApprovalStatus(String username);

void addBlogComment(BlogComment blogComment);

List<BlogComment> getBlogComments(int blogPostId);
}