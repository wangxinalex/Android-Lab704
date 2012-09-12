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
public class ItemDaoHibernate extends HibernateDaoSupport implements ItemDao {
	/**
	 * get item by id
	 */
	public Item get(Integer itemId) {
		return (Item) getHibernateTemplate().get(Item.class, itemId);
	}

	/**
	 * save item
	 */
	public void save(Item item) {
		getHibernateTemplate().save(item);
	}

	/**
	 * change items
	 */
	public void update(Item item) {
		getHibernateTemplate().saveOrUpdate(item);
	}

	/**
	 * delete item by id
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * delete item
	 */
	public void delete(Item item) {
		getHibernateTemplate().delete(item);
	}

	/**
	 * get all items by kind
	 */
	public List<Item> findItemByKind(Integer kindId) {
		return (List<Item>) getHibernateTemplate().find(
				"from Item as i where i.kind.id = ? and i.itemState.id = 1",
				kindId);
	}
/**
 *get item by name
 */
	public Item findItemByName(String name){
		System.out.println("itemName = "+name);
		List<Item> items=getHibernateTemplate().find("from Item as i where i.itemName= ? ",
				name); 
		return items.get(0);
	}
	/**
	 * find all items owned by user
	 */
	public List<Item> findItemByOwner(Integer userId) {
		return (List<Item>) getHibernateTemplate().find(
				"from Item as i where i.owner.id = ? and i.itemState.id = 1",
				userId);
	}

	/**
	 * find items by winner
	 */
	public List<Item> findItemByWiner(Integer userId) {
		return (List<Item>) getHibernateTemplate().find(
				"from Item as i where i.winer.id = ? and i.itemState.id = 2",
				userId);
	}

	/**
	 * find items by state
	 */
	public List<Item> findItemByState(Integer stateId) {
		return (List<Item>) getHibernateTemplate().find(
				"from Item as i where i.itemState.id = ?", stateId);
	}
}