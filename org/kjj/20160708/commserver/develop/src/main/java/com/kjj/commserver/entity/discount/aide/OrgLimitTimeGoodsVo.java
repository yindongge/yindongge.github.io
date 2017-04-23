package com.kjj.commserver.entity.discount.aide;

import java.util.Date;

import com.kjj.commserver.entity.discount.OrgLimitTimeDiscount;
import com.kjj.commserver.entity.discount.OrgLimitTimeGoods;

public class OrgLimitTimeGoodsVo extends OrgLimitTimeGoods {
	
	/** 限时折扣信息 */
	private OrgLimitTimeDiscount orgLimitTimeDiscount;
	
	/** 店铺已卖量 */
	private Integer shopBuyNum;
	
	/** 个人已买量 */
	private Integer userBuyNum;
	
	/** 服务器时间 */
	private Date dbDate;
	
	public OrgLimitTimeDiscount getOrgLimitTimeDiscount() {
		return orgLimitTimeDiscount;
	}

	public void setOrgLimitTimeDiscount(OrgLimitTimeDiscount orgLimitTimeDiscount) {
		this.orgLimitTimeDiscount = orgLimitTimeDiscount;
		//标题
		if (super.getGoodsTitle() == null) {
			super.setGoodsTitle(orgLimitTimeDiscount.getTitle());
		}
	}

	public Integer getShopBuyNum() {
		return shopBuyNum;
	}

	public void setShopBuyNum(Integer shopBuyNum) {
		this.shopBuyNum = shopBuyNum;
	}

	public Integer getUserBuyNum() {
		return userBuyNum;
	}

	public void setUserBuyNum(Integer userBuyNum) {
		this.userBuyNum = userBuyNum;
	}
	
	public Date getDbDate() {
		return dbDate;
	}

	public void setDbDate(Date dbDate) {
		this.dbDate = dbDate;
	}
}