package com.kjj.commserver.entity.order.aide;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.kjj.commserver.entity.order.OrgOrder;

public class OrgOrderQuery extends OrgOrder {
	
	/** 管理员店铺权限  */
	private Collection<Integer> shopIds;
	
	/** 状态 */
	private Byte queryStatus;
	
	/** 商品名称 */
	private String goodsNameLike;
	
	/** 订单号 */
	private String orderIdLike;	
	
	/** 收货人 */
	private String consigneeLike;	
	
	/** 下单起始时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date createTimeStart;	
	
	/** 下单结束时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date createTimeEnd;
	
	/** 提货码 */
	private String takeCodeLike;
	
	/** 待付款订单数量 */
	private Boolean waitPaid = false;
	
	/** 待收货订单数量 */
	private Boolean waitSend = false;
	
	/** 待自提订单数量 */
	private Boolean waitTake = false;
	
	/** 待评价订单数量 */
	private Boolean waitComment = false;
	
	/** 超时订单 */
	private Boolean timeOut = false;
	
	/** 选择的店铺 */
	private Collection<Integer> shopSelect;

	public Collection<Integer> getShopIds() {
		return shopIds;
	}

	public void setShopIds(Collection<Integer> shopIds) {
		this.shopIds = shopIds;
	}

	public Byte getQueryStatus() {
		return queryStatus;
	}

	public void setQueryStatus(Byte queryStatus) {
		this.queryStatus = queryStatus;
	}

	public String getGoodsNameLike() {
		return goodsNameLike;
	}

	public void setGoodsNameLike(String goodsNameLike) {
		this.goodsNameLike = goodsNameLike;
	}

	public String getOrderIdLike() {
		return orderIdLike;
	}

	public void setOrderIdLike(String orderIdLike) {
		this.orderIdLike = orderIdLike;
	}

	public Date getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(Date createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public Date getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(Date createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getConsigneeLike() {
		return consigneeLike;
	}

	public void setConsigneeLike(String consigneeLike) {
		this.consigneeLike = consigneeLike;
	}

	public String getTakeCodeLike() {
		return takeCodeLike;
	}

	public void setTakeCodeLike(String takeCodeLike) {
		this.takeCodeLike = takeCodeLike;
	}

	public Boolean getWaitPaid() {
		return waitPaid;
	}

	public void setWaitPaid(Boolean waitPaid) {
		this.waitPaid = waitPaid;
	}

	public Boolean getWaitSend() {
		return waitSend;
	}

	public void setWaitSend(Boolean waitSend) {
		this.waitSend = waitSend;
	}

	public Boolean getWaitTake() {
		return waitTake;
	}

	public void setWaitTake(Boolean waitTake) {
		this.waitTake = waitTake;
	}

	public Boolean getWaitComment() {
		return waitComment;
	}

	public void setWaitComment(Boolean waitComment) {
		this.waitComment = waitComment;
	}

	public Boolean getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Boolean timeOut) {
		this.timeOut = timeOut;
	}

	public Collection<Integer> getShopSelect() {
		return shopSelect;
	}

	public void setShopSelect(Collection<Integer> shopSelect) {
		this.shopSelect = shopSelect;
	}


}