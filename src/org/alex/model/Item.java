package org.alex.model;

import java.util.*;

/**
 * Description:
 * 
 * @author lab704
 * @version 1.0
 */
public class Item {

	private Integer id;

	private String itemRemark;

	private String itemName;

	private String itemDesc;

	private Date addtime;

	private Date endtime;

	private double initPrice;

	private double maxPrice;

	private CallingUser owner;

	private Kind kind;

	private CallingUser winer;

	private State itemState;

	private Set<Bid> bids = new HashSet<Bid>();

	public Item() {
	}

	public Item(Integer id, String itemRemark, String itemName,
			String itemDesc, Date addtime, Date endtime, double initPrice,
			double maxPrice, CallingUser owner) {
		this.id = id;
		this.itemRemark = itemRemark;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.addtime = addtime;
		this.endtime = endtime;
		this.initPrice = initPrice;
		this.maxPrice = maxPrice;
		this.owner = owner;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setItemRemark(String itemRemark) {
		this.itemRemark = itemRemark;
	}

	public String getItemRemark() {
		return this.itemRemark;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Date getAddtime() {
		return this.addtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setInitPrice(double initPrice) {
		this.initPrice = initPrice;
	}

	public double getInitPrice() {
		return this.initPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public double getMaxPrice() {
		return this.maxPrice;
	}

	public void setOwner(CallingUser owner) {
		this.owner = owner;
	}

	public CallingUser getOwner() {
		return this.owner;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public Kind getKind() {
		return this.kind;
	}

	public void setWiner(CallingUser winer) {
		this.winer = winer;
	}

	public CallingUser getWiner() {
		return this.winer;
	}

	public void setItemState(State itemState) {
		this.itemState = itemState;
	}

	public State getItemState() {
		return this.itemState;
	}

	public void setBids(Set<Bid> bids) {
		this.bids = bids;
	}

	public Set<Bid> getBids() {
		return this.bids;
	}
}