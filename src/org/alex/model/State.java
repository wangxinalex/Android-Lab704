package org.alex.model;

import java.util.*;

/**
 * Description:
 * 
 * @author lab704
 * @version 1.0
 */
public class State {

	private Integer id;

	private String stateName;

	private Set<Item> items = new HashSet<Item>();

	public State() {
	}

	public State(Integer id, String stateName) {
		this.id = id;
		this.stateName = stateName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Set<Item> getItems() {
		return this.items;
	}
}