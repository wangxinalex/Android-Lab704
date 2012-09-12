package org.alex.model;

import java.util.*;

/**
 * Description:
 * 
 * @author lab704
 * @version 1.0
 */
public class Kind {

	private Integer id;

	private String kindName;

	private String kindDesc;

	private Set<Item> items = new HashSet<Item>();

	public Kind() {
	}

	public Kind(Integer id, String kindName, String kindDesc) {
		this.id = id;
		this.kindName = kindName;
		this.kindDesc = kindDesc;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getKindName() {
		return this.kindName;
	}

	public void setKindDesc(String kindDesc) {
		this.kindDesc = kindDesc;
	}

	public String getKindDesc() {
		return this.kindDesc;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public Set<Item> getItems() {
		return this.items;
	}

}