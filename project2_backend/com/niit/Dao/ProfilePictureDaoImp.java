package com.niit.Dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Model.ProfilePicture;
@Repository
@Transactional
public class ProfilePictureDaoImp implements ProfilePictureDao{
    @Autowired
	private SessionFactory sessionFactory;
	public void saveProfilePicture(ProfilePicture profilePicture) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);
		
	}

	public ProfilePicture getProfilePicture(String username) {
		Session session=sessionFactory.getCurrentSession();
		//select * from profilepicture where username='admin'
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, username);
		return profilePicture;
	}

}
