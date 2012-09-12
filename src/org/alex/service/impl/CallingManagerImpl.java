package org.alex.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.alex.business.BidBean;
import org.alex.business.ItemBean;
import org.alex.business.KindBean;
import org.alex.dao.CallingUserDao;
import org.alex.dao.BidDao;
import org.alex.dao.ItemDao;
import org.alex.dao.KindDao;
import org.alex.dao.StateDao;
import org.alex.exception.CallingException;
import org.alex.model.Bid;
import org.alex.model.CallingUser;
import org.alex.model.Item;
import org.alex.model.Kind;
import org.alex.service.CallingManager;
import org.apache.log4j.Logger;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Description: <br/>
 * 
 * @author lab704
 * @version 1.0
 */
public class CallingManagerImpl implements CallingManager {
	static Logger log = Logger.getLogger(CallingManagerImpl.class.getName());

	private CallingUserDao userDao;
	private BidDao bidDao;
	private ItemDao itemDao;
	private KindDao kindDao;
	private StateDao stateDao;

	private MailSender mailSender;
	private SimpleMailMessage message;

	public void setUserDao(CallingUserDao userDao) {
		this.userDao = userDao;
	}

	public void setBidDao(BidDao bidDao) {
		this.bidDao = bidDao;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void setKindDao(KindDao kindDao) {
		this.kindDao = kindDao;
	}

	public void setStateDao(StateDao stateDao) {
		this.stateDao = stateDao;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}

	/**
	 * get items by winner id
	 */
	public List<ItemBean> getItemByWiner(Integer winerId)
			throws CallingException {
		try {
			List<Item> items = itemDao.findItemByWiner(winerId);
			List<ItemBean> result = new ArrayList<ItemBean>();
			for (Item item : items) {
				ItemBean ib = new ItemBean();
				initItem(ib, item);
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new CallingException("查询用户所赢取的资源出现异常,请重试");
		}
	}

	/**
	 * get all items
	 */
	public List<ItemBean> getFailItems() throws CallingException {
		try {
			List<Item> items = itemDao.findItemByState(3);
			List<ItemBean> result = new ArrayList<ItemBean>();
			for (Item item : items) {
				ItemBean ib = new ItemBean();
				initItem(ib, item);
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new CallingException("查询流拍预约出现异常,请重试");
		}
	}

	/**
	 * validate whether the user has logged successfully
	 */
	public int validLogin(String username, String pass) throws CallingException {
		try {
			CallingUser u = userDao.findUserByNameAndPass(username, pass);
			if (u != null) {
				return u.getId();
			}
			return -1;
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new CallingException("处理用户登录出现异常,请重试");
		}
	}

	/**
	 * get all bids by uer id
	 */
	public List<BidBean> getBidByUser(Integer userId) throws CallingException {
		try {
			List<Bid> l = bidDao.findByUser(userId);
			List<BidBean> result = new ArrayList<BidBean>();
			for (int i = 0; i < l.size(); i++) {
				Bid bid = l.get(i);
				BidBean bb = new BidBean();
				initBid(bb, bid);
				result.add(bb);
			}
			return result;
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new CallingException("浏览用户的全部预约出现异常,请重试");
		}
	}

	public void updateBidById(Integer bidId, Integer userId, String bidPost)
			throws CallingException {
		Bid bid = bidDao.get(bidId);
		CallingUser user = userDao.get(userId);
		String userName = user.getUsername();
		String post = ((bid.getBidPost().length() == 0) ? (userName + "愿意加入")
				: (bid.getBidPost() + "\n" + userName + "愿意加入"));
		bid.setBidPost(post);
		bidDao.update(bid);
	}

	/**
	 * get all bids
	 * */
	public List<BidBean> getAllBids() {
		try {
			List<Bid> l = bidDao.findAllBids();
			List<BidBean> result = new ArrayList<BidBean>();
			for (int i = 0; i < l.size(); i++) {
				Bid bid = l.get(i);
				BidBean bb = new BidBean();
				initBid(bb, bid);
				result.add(bb);
			}
			return result;
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new CallingException("浏览全部预约出现异常,请重试");
		}

	}

	/**
	 * get all items by owner id
	 */
	public List<ItemBean> getItemsByOwner(Integer userId)
			throws CallingException {
		try {
			List<ItemBean> result = new ArrayList<ItemBean>();
			List<Item> items = itemDao.findItemByOwner(userId);
			for (Item item : items) {
				ItemBean ib = new ItemBean();
				initItem(ib, item);
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new CallingException("查询用户所有的预约出现异常,请重试");
		}
	}

	/**
	 * get all kinds
	 */
	public List<KindBean> getAllKind() throws CallingException {
		List<KindBean> result = new ArrayList<KindBean>();
		try {
			List<Kind> kl = kindDao.findAll();
			for (Kind k : kl) {
				result.add(new KindBean(k.getId(), k.getKindName(), k
						.getKindDesc()));
			}
			return result;
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new CallingException("查询全部种类出现异常,请重试");
		}
	}

	/**
	 * add new items
	 */
	public int addItem(String name, String desc, String remark,
			double initPrice, int avail, int kind, Integer userId)
			throws CallingException {
		System.out.println("userId ===" + userId);
		// try
		// {
		System.out.println("---" + kind);
		Kind k = kindDao.get(kind);
		CallingUser owner = userDao.get(userId);

		Item item = new Item();
		item.setItemName(name);
		item.setItemDesc(desc);
		item.setItemRemark(remark);
		item.setAddtime(new Date());
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, avail);
		// SimpleDateFormat p = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// try {
		// Date e=p.parse("2012-12-12 11:11:11");
		//
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		item.setEndtime(c.getTime());
		item.setInitPrice(new Double(initPrice));
		item.setMaxPrice(new Double(initPrice));
		item.setItemState(stateDao.get(1));
		item.setKind(k);
		item.setOwner(owner);

		itemDao.save(item);
		return item.getId();
		// }
		// catch (Exception e)
		// {
		// e.printStackTrace();
		// log.debug(e.getMessage());
		// throw new AuctionException("添加资源出现异常,请重试");
		// }
	}

	/**
	 * add new kinds
	 */
	public int addKind(String name, String desc) throws CallingException {
		try {
			Kind k = new Kind();
			k.setKindName(name);
			k.setKindDesc(desc);
			kindDao.save(k);
			return k.getId();
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new CallingException("添加种类出现异常,请重试");
		}
	}

	/**
	 * add new user
	 * */
	public int register(String userName, String userPass, String userEmail)
			throws CallingException {
		try {
			System.out.println("Add User:");
			CallingUser user = new CallingUser();
			user.setUsername(userName);
			user.setUserpass(userPass);
			user.setEmail(userEmail);
			userDao.save(user);
			return user.getId();
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new CallingException("用户注册出现异常，请重试");
		}
	}

	/**
	 * get all items by kind
	 */
	public List<ItemBean> getItemsByKind(int kindId) throws CallingException {
		List<ItemBean> result = new ArrayList<ItemBean>();
		try {
			List<Item> items = itemDao.findItemByKind(kindId);
			for (Item item : items) {
				ItemBean ib = new ItemBean();
				initItem(ib, item);
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			log.debug(e.getMessage());
			throw new CallingException("根据种类获取预约出现异常,请重试");
		}
	}

	/**
	 * get kind by id
	 */
	public String getKind(int kindId) throws CallingException {
		try {
			Kind k = kindDao.get(kindId);
			if (k != null) {
				return k.getKindName();
			}
			return null;
		} catch (Exception ex) {
			log.debug(ex.getMessage());
			throw new CallingException("根据种类id获取种类名称出现异常,请重试");
		}
	}

	/**
	 * get items by id
	 */
	public ItemBean getItem(int itemId) throws CallingException {
		try {
			Item item = itemDao.get(itemId);
			ItemBean ib = new ItemBean();
			initItem(ib, item);
			return ib;
		} catch (Exception ex) {
			log.debug(ex.getMessage());
			throw new CallingException("根据预约id获取预约详细信息出现异常,请重试");
		}
	}

	/**
	 * add new bids
	 */
	public int addBid(int itemId, double bidPrice, String dateTime,
			String bidPost, Integer userId) throws CallingException {
		try {
			CallingUser au = userDao.get(userId);

			Item item = itemDao.get(itemId);
			if (bidPrice > item.getMaxPrice()) {
				item.setMaxPrice(new Double(bidPrice));
				itemDao.save(item);
			}

			Bid bid = new Bid();
			bid.setBidItem(item);
			bid.setBidUser(au);
			SimpleDateFormat p = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			bid.setBidDate(p.parse(dateTime));
			bid.setBidPost(au.getUsername() + "已预约事件：\n" + bidPost
					+ "\n呼朋引伴中...");
			System.out.println("Date>>>" + dateTime + p.parse(dateTime));
			bid.setBidPrice(bidPrice);

			bidDao.save(bid);

			SimpleMailMessage msg = new SimpleMailMessage(this.message);
			msg.setTo(au.getEmail());
			msg.setText("Dear " + au.getUsername() + ", 谢谢你参与预约，你的预约的预约是: "
					+ item.getItemName());
			mailSender.send(msg);
			return bid.getId();
		} catch (Exception ex) {
			log.debug(ex.getMessage());
			throw new CallingException("处理用户预约出现异常,请重试");
		}
	}

	public void deleteBidById(Integer bidId, Integer userId) {
		// TODO Auto-generated method stub
		Bid bid = bidDao.get(bidId);
		// CallingUser user = userDao.get(userId);
		// String userName = user.getUsername();
		// String post =
		// (bid.getBidPost().length()==0?(userName+"愿意加入"):(bid.getBidPost()+"\n"+userName+"愿意加入"));
		// bid.setBidPost(post);
		bidDao.delete(bid);
	}

	/**
	 * update item state by time
	 */
	@SuppressWarnings("rawtypes")
	public void updateWiner() throws CallingException {
		try {
			List itemList = itemDao.findItemByState(1);
			for (int i = 0; i < itemList.size(); i++) {
				Item item = (Item) itemList.get(i);
				if (!item.getEndtime().after(new Date())) {
					// get user by maximum price
					CallingUser au = bidDao.findUserByItemAndPrice(
							item.getId(), item.getMaxPrice());

					if (au != null) {

						item.setWiner(au);
						// set state to 'owned'
						item.setItemState(stateDao.get(2));
						itemDao.save(item);
					} else {
						// set state to 'failed'
						item.setItemState(stateDao.get(3));
						itemDao.save(item);
					}
				}
			}
		} catch (Exception ex) {
			log.debug(ex.getMessage());
			throw new CallingException("根据时间来修改资源的状态、赢取者出现异常,请重试");
		}
	}

	/**
	 * pack Bid object as BidBean object
	 */
	private void initBid(BidBean bb, Bid bid) {
		bb.setId(bid.getId().intValue());
		if (bid.getBidUser() != null)
			bb.setUser(bid.getBidUser().getUsername());
		if (bid.getBidItem() != null)
			bb.setItem(bid.getBidItem().getItemName());
		bb.setPrice(bid.getBidPrice());
		bb.setBidDate(bid.getBidDate());
		bb.setBidPost(bid.getBidPost());
	}

	/**
	 * change Item object to ItemBean owner
	 */
	private void initItem(ItemBean ib, Item item) {
		ib.setId(item.getId());
		ib.setName(item.getItemName());
		ib.setDesc(item.getItemDesc());
		ib.setRemark(item.getItemRemark());
		if (item.getKind() != null)
			ib.setKind(item.getKind().getKindName());
		if (item.getOwner() != null)
			ib.setOwner(item.getOwner().getUsername());
		if (item.getWiner() != null)
			ib.setWiner(item.getWiner().getUsername());
		ib.setAddTime(item.getAddtime());
		ib.setEndTime(item.getEndtime());
		if (item.getItemState() != null)
			ib.setState(item.getItemState().getStateName());
		ib.setInitPrice(item.getInitPrice());
		ib.setMaxPrice(item.getMaxPrice());
	}

	public ItemBean getItemByName(String itemName) {
		// TODO Auto-generated method stub
		System.out.println("itemName0 = "+itemName);
		Item item = itemDao.findItemByName(itemName);
		ItemBean itemBean= new ItemBean();
		initItem(itemBean, item);
		return itemBean;
	}

}