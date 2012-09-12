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
public interface BidDao {
	/**
	 * find the record by id
	 */
	Bid get(Integer bidId);

	/**
	 * save the records
	 */
	void save(Bid bid);

	/**
	 * change the record
	 */
	void update(Bid bid);

	/**
	 * delete the records
	 */
	void delete(Integer id);

	/**
	 * delete records
	 */
	void delete(Bid bid);

	/**
	 * find user by item id
	 */
	List<Bid> findByUser(Integer userId);

	/**
	 * find user by item id and price
	 */
	CallingUser findUserByItemAndPrice(Integer itemId, Double price);

	/**
	 * find all records
	 * */
	List<Bid> findAllBids();

}
