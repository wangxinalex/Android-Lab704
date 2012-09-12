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
public interface KindDao {
	/**
	 * select kind by id
	 */
	Kind get(Integer id);

	/**
	 * add kind
	 */
	void save(Kind kind);

	/**
	 * change items
	 */
	void update(Kind kind);

	/**
	 * delete items by id
	 */
	void delete(Integer id);

	/**
	 * delete items
	 */
	void delete(Kind kind);

	/**
	 * find all items
	 */
	List<Kind> findAll();
}
