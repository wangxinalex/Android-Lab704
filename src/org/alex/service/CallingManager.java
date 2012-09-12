package org.alex.service;

import java.util.List;

import org.alex.business.*;
import org.alex.dao.*;
import org.alex.exception.CallingException;
import org.alex.model.CallingUser;

/**
 * Description:
 * 
 * @author lab704
 * @version 1.0
 */
public interface CallingManager {
	/**
	 * find item by winner
	 */
	List<ItemBean> getItemByWiner(Integer winerId) throws CallingException;

	/**
	 * find all items
	 */
	List<ItemBean> getFailItems() throws CallingException;

	/**
	 * validate whether the user has logged successfully
	 */
	int validLogin(String username, String pass) throws CallingException;

	/**
	 * get all records by user id
	 */
	List<BidBean> getBidByUser(Integer userId) throws CallingException;

	/**
	 * find items by owner id
	 */
	List<ItemBean> getItemsByOwner(Integer userId) throws CallingException;

	/**
	 * select all kinds
	 */
	List<KindBean> getAllKind() throws CallingException;

	/**
	 * add items
	 */
	int addItem(String name, String desc, String remark, double initPrice,
			int avail, int kind, Integer userId) throws CallingException;

	/**
	 * add kind
	 */
	int addKind(String name, String desc) throws CallingException;

	/**
	 * get items by kind
	 */
	List<ItemBean> getItemsByKind(int kindId) throws CallingException;

	/**
	 * get kind name by id
	 */
	String getKind(int kindId) throws CallingException;

	/**
	 * get item by id
	 */
	ItemBean getItem(int itemId) throws CallingException;

	/**
	 * add new bids
	 * @param bidPost 
	 */
	int addBid(int itemId, double bidPrice, String dateTime, String bidPost, Integer userId)
			throws CallingException;

	/**
	 * update winner by time
	 */
	void updateWiner() throws CallingException;

	/**
	 * add new users
	 * */
	int register(String userName, String userPass, String userEmail);

	/**
	 * get all bids
	 * */
	List<BidBean> getAllBids();

	void updateBidById(Integer bidId, Integer userId, String bidPost);

	void deleteBidById(Integer bidId, Integer userId);
	ItemBean getItemByName(String itemName);
}