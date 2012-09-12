package org.alex.dao;

import java.util.List;

import org.alex.business.*;
import org.alex.model.*;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
public interface ItemDao  
{
	/**
	 * find item by primary id 
	
	 */
	Item get(Integer itemId);

	/**
	 * save item
	
	 */
	void save(Item item);

	/**
	 * change item
	
	 */
	void update(Item item);

	/**
	 * delete item by id
	
	 */
	void delete(Integer id);

	/**
	 * delete item
	
	 */
	void delete(Item item);

	/**
	 * find item by kind

	 */
	List<Item> findItemByKind(Integer kindId);

	/**
	 * find items by owner
	 */
	List<Item> findItemByOwner(Integer userId);

	/**
	 * find items by winner
	
	 */
	List<Item> findItemByWiner(Integer userId);

	/**
	 * find items by state
	
	 */
	List<Item> findItemByState(Integer stateId);
	/**
	 * find item by name
	 */
	 Item findItemByName(String name);
}