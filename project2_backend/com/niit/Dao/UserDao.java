
package com.niit.Dao;

import com.niit.Model.User;

public interface UserDao {
void registration(User user);
boolean isEmailValid(String email);
boolean isUsernameValid(String username);
User login(User user);
void updateUser(User validUser);
User getUserByUsername(String username);
}

