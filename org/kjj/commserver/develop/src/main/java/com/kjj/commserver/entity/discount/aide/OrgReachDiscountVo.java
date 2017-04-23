package com.kjj.commserver.entity.discount.aide;

import java.math.BigDecimal;
import java.util.List;

import com.kjj.commserver.entity.discount.OrgReachCoupon;
import com.kjj.commserver.entity.discount.OrgReachDiscount;
import com.kjj.commserver.entity.goods.OrgProductItem;

public class OrgReachDiscountVo extends OrgReachDiscount {
	
	/** 赠品 */
	private List<OrgProductItem> listReachGive;
	
	/** 优惠券 */
	private List<OrgReachCoupon> listReachCoupon;
	
	/** 优惠倍数 */
	private Integer discountMultiple = null;
	
	/** 调整金额 */
	private BigDecimal balance = BigDecimal.ZERO;
	
	public List<OrgProductItem> getListReachGive() {
		return listReachGive;
	}

	public void setListReachGive(List<OrgProductItem> listReachGive) {
		this.listReachGive = listReachGive;
	}

	public List<OrgReachCoupon> getListReachCoupon() {
		return listReachCoupon;
	}

	public void setListReachCoupon(List<OrgReachCoupon> listReachCoupon) {
		this.listReachCoupon = listReachCoupon;
	}

	public Integer getDiscountMultiple() {
		return discountMultiple;
	}

	public void setDiscountMultiple(Integer discountMultiple) {
		this.discountMultiple = discountMultiple;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}