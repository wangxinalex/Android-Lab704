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
public class KindDaoHibernate extends HibernateDaoSupport implements KindDao {
	/**
	 * find kind by id
	 */
	public Kind get(Integer id) {
		return (Kind) getHibernateTemplate().get(Kind.class, id);
	}

	/**
	 * add kind
	 */
	public void save(Kind kind) {
		getHibernateTemplate().save(kind);
	}

	/**
	 * change kind
	 */
	public void update(Kind kind) {
		getHibernateTemplate().saveOrUpdate(kind);
	}

	/**
	 * delete kind by id
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * delete kind
	 */
	public void delete(Kind kind) {
		getHibernateTemplate().delete(kind);
	}

	/**
	 * get all kinds
	 */
	public List<Kind> findAll() {
		return (List<Kind>) getHibernateTemplate().find("from Kind");
	}
}
