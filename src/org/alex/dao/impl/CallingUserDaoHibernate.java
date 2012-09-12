package org.alex.dao.impl;

import java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.alex.business.*;
import org.alex.dao.*;
import org.alex.model.*;

/**
 * Description:
 * 
 * @author lab704
 * @version 1.0
 */
public class CallingUserDaoHibernate extends HibernateDaoSupport implements
		CallingUserDao {
	/**
	 * find user by id
	 */
	public CallingUser get(Integer id) {
		return (CallingUser) getHibernateTemplate().get(CallingUser.class, id);
	}

	/**
	 * add user
	 */
	public void save(CallingUser user) {
		getHibernateTemplate().save(user);
	}

	/**
	 * change user
	 */
	public void update(CallingUser user) {
		getHibernateTemplate().saveOrUpdate(user);
	}

	/**
	 * delete user by id
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * delete user
	 */
	public void delete(CallingUser user) {
		getHibernateTemplate().delete(user);
	}

	/**
	 * get all users
	 */
	public List<CallingUser> findAll() {
		return (List<CallingUser>) getHibernateTemplate().find(
				"from CallingUser");
	}

	/**
	 * find user by name and password
	 */
	public CallingUser findUserByNameAndPass(String username, String pass) {
		// execute HQL statement
		List<CallingUser> ul = (List<CallingUser>) getHibernateTemplate()
				.find("from CallingUser cu where cu.username = ? and cu.userpass = ?",
						username, pass);

		if (ul.size() == 1) {
			return (CallingUser) ul.get(0);
		}
		return null;
	}
}