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
public interface StateDao {
	/**
	 * get state by id
	 */
	State get(Integer id);

	/**
	 * add state
	 */
	void save(State state);

	/**
	 * change state
	 */
	void update(State state);

	/**
	 * delete state by id
	 */
	void delete(Integer id);

	/**
	 * delete state
	 */
	void delete(State state);

	/**
	 * find all states
	 */
	List<State> findAll();
}
