package org.alex.dao.impl;

import java.util.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.Hibernate;

import org.alex.business.*;
import org.alex.dao.*;
import org.alex.model.*;

/**
 * Description:
 * 
 * @author lab704
 * @version 1.0
 */
public class StateDaoHibernate extends HibernateDaoSupport implements StateDao {
	/**
	 * get state by id
	 */
	public State get(Integer id) {
		return (State) getHibernateTemplate().get(State.class, id);
	}

	/**
	 * add state
	 */
	public void save(State state) {
		getHibernateTemplate().save(state);
	}

	/**
	 * change state
	 */
	public void update(State state) {
		getHibernateTemplate().saveOrUpdate(state);
	}

	/**
	 * delete state by id
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * delete state
	 */
	public void delete(State state) {
		getHibernateTemplate().delete(state);
	}

	/**
	 * find all states
	 */
	public List<State> findAll() {
		return (List<State>) getHibernateTemplate().find("from State");
	}
}