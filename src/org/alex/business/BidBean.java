package org.alex.business;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:JavaBean of Bid object, independent from any other beans
 * 
 * @author lab704
 * @version 1.0
 */
public class BidBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String user;
	private String item;
	private double price;
	private Date bidDate;
	private String bidPost;

	public String getBidPost() {
		return bidPost;
	}

	public void setBidPost(String bidPost) {
		this.bidPost = bidPost;
	}

	public BidBean() {
	}

	public BidBean(Integer id, String user, String item, double price,
			Date bidDate) {
		this.id = id;
		this.user = user;
		this.item = item;
		this.price = price;
		this.bidDate = bidDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return this.user;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem() {
		return this.item;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public Date getBidDate() {
		return this.bidDate;
	}

}