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
public class BidDaoHibernate extends HibernateDaoSupport implements BidDao {
	/**
	 * get the records by id
	 */
	public Bid get(Integer bidId) {
		return (Bid) getHibernateTemplate().get(Bid.class, bidId);
	}

	/**
	 * save records
	 */
	public void save(Bid bid) {
		getHibernateTemplate().save(bid);
	}

	/**
	 * change records
	 */
	public void update(Bid bid) {
		getHibernateTemplate().saveOrUpdate(bid);
	}

	/**
	 * delete records by id
	 */
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	/**
	 * delete records
	 */
	public void delete(Bid bid) {
		getHibernateTemplate().delete(bid);
	}

	/**
	 * find records by user
	 */
	@SuppressWarnings("unchecked")
	public List<Bid> findByUser(Integer userId) {
		return (List<Bid>) getHibernateTemplate().find(
				"from Bid as bid where bid.bidUser.id = ?", userId);
	}
	
	/**
	 * find all records
	 * */
	@SuppressWarnings("unchecked")
	public List<Bid> findAllBids() {
		return (List<Bid>) getHibernateTemplate().find("from Bid");
	}

	/**
	 * find user by id and price
	 */
	public CallingUser findUserByItemAndPrice(Integer itemId, Double price) {

		List<Bid> l = (List<Bid>) getHibernateTemplate()
				.find("from Bid as bid where bid.bidItem.id = ? and bid.bidPrice = ?",
						new Object[] { itemId, price });

		if (l.size() >= 1) {
			Bid b = (Bid) l.get(0);
			return b.getBidUser();
		}
		return null;
	}
}
