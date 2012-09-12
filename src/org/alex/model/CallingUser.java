package org.alex.model;

import java.util.*;

/**
 * Description:
 * 
 * @author lab704
 * @version 1.0
 */
public class CallingUser {

	private Integer id;

	private String username;

	private String userpass;

	private String email;

	private Set<Item> itemsByOwner = new HashSet<Item>();

	private Set<Item> itemsByWiner = new HashSet<Item>();

	private Set<Bid> bids = new HashSet<Bid>();

	public CallingUser() {
	}

	public CallingUser(Integer id, String username, String userpass,
			String email) {
		this.id = id;
		this.username = username;
		this.userpass = userpass;
		this.email = email;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUserpass() {
		return this.userpass;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setItemsByOwner(Set<Item> itemsByOwner) {
		this.itemsByOwner = itemsByOwner;
	}

	public Set<Item> getItemsByOwner() {
		return this.itemsByOwner;
	}

	public void setItemsByWiner(Set<Item> itemsByWiner) {
		this.itemsByWiner = itemsByWiner;
	}

	public Set<Item> getItemsByWiner() {
		return this.itemsByWiner;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	public Set<Bid> getBids() {
		return this.bids;
	}
}