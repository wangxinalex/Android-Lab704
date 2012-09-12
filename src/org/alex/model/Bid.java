package org.alex.model;

import java.util.*;

/**
 * Description:
 * 
 * @author lab704
 * @version 1.0
 */
public class Bid {

	private Integer id;

	private double bidPrice;

	private Date bidDate;

	private Item bidItem;

	private CallingUser bidUser;

	private String bidPost;
	
	public String getBidPost() {
		return bidPost;
	}

	public void setBidPost(String bidPost) {
		this.bidPost = bidPost;
	}

	public Bid() {
	}

	public Bid(Integer id, double bidPrice, Date bidDate) {
		this.id = id;
		this.bidPrice = bidPrice;
		this.bidDate = bidDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}

	public double getBidPrice() {
		return this.bidPrice;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public Date getBidDate() {
		return this.bidDate;
	}

	public void setBidItem(Item bidItem) {
		this.bidItem = bidItem;
	}

	public Item getBidItem() {
		return this.bidItem;
	}

	public void setBidUser(CallingUser bidUser) {
		this.bidUser = bidUser;
	}

	public CallingUser getBidUser() {
		return this.bidUser;
	}

	public int hashCode() {
		return bidUser.getUsername().hashCode() + bidItem.hashCode() * 13
				+ (int) bidPrice * 19;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == Bid.class) {
			Bid bid = (Bid) obj;
			if (bid.getBidUser().getUsername().equals(bidUser.getUsername())
					&& bid.getBidItem().equals(this.getBidItem())
					&& bid.getBidPrice() == this.getBidPrice()) {
				return true;
			}
		}
		return false;
	}

	
}