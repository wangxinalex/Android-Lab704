package org.alex.business;

import java.util.Date;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
public class ItemBean
{
	private Integer id;
	private String name;
	private String desc;
	private String remark;
	private String kind;
	private String owner;
	private String winer;
	private String state;
	private double initPrice;
	private double maxPrice;
	private Date addTime;
	private Date endTime;


	public ItemBean()
	{
	}

	public ItemBean(Integer id , String name , String desc , String remark,
		String kind , String owner , String winer , String state ,
		double initPrice , double maxPrice , Date addTime , Date endTime)
	{
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.remark = remark;
		this.kind = kind;
		this.owner = owner;
		this.winer = winer;
		this.state = state;
		this.initPrice = initPrice;
		this.maxPrice = maxPrice;
		this.addTime = addTime;
		this.endTime = endTime;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}


	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}


	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		return this.desc;
	}


	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		return this.remark;
	}

	public void setKind(String kind)
	{
		this.kind = kind;
	}
	public String getKind()
	{
		return this.kind;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	public String getOwner()
	{
		return this.owner;
	}

	public void setWiner(String winer)
	{
		this.winer = winer;
	}
	public String getWiner()
	{
		return this.winer;
	}

	
	public void setState(String state)
	{
		this.state = state;
	}
	public String getState()
	{
		return this.state;
	}

	public void setInitPrice(double initPrice)
	{
		this.initPrice = initPrice;
	}
	public double getInitPrice()
	{
		return this.initPrice;
	}

	
	public void setMaxPrice(double maxPrice)
	{
		this.maxPrice = maxPrice;
	}
	public double getMaxPrice()
	{
		return this.maxPrice;
	}

	
	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}
	public Date getAddTime()
	{
		return this.addTime;
	}

	
	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}
	public Date getEndTime()
	{
		return this.endTime;
	}
}