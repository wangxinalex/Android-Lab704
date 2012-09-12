package org.alex.dao;

import java.util.List;

import org.alex.business.*;
import org.alex.model.*;

/**
 * Description:
 * 
 * @author lab704
 * @version 1.0
 */
public interface CallingUserDao {
	/**
	 * select user by id
	 */
	CallingUser get(Integer id);

	/**
	 * add user
	 */
	void save(CallingUser user);

	/**
	 * update user
	 */
	void update(CallingUser user);

	/**
	 * delete user by id
	 */
	void delete(Integer id);

	/**
	 * delete user
	 */
	void delete(CallingUser user);

	/**
	 * select all users
	 */
	List<CallingUser> findAll();

	/**
	 * find user by name and password
	 */
	CallingUser findUserByNameAndPass(String username, String pass);
}