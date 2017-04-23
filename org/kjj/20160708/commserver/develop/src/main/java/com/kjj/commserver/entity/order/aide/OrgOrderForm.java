package com.kjj.commserver.entity.order.aide;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.kjj.commserver.entity.account.aide.OrgAccountDepositVo;
import com.kjj.commserver.entity.discount.OrgCouponRecord;
import com.kjj.commserver.entity.discount.OrgReach;
import com.kjj.commserver.entity.order.OrgOrder;

public class OrgOrderForm extends OrgOrder {
	
	/** 下单商品 */
	private Collection<Integer> goodsIds;
	
	/** 使用的优惠券ID */
	private Integer couponRecordId;
	
	/** 收货地址ID */
	private Integer addressId;
	
	/** 是否有发票*/
	private Boolean takeInvoice;
	
	/** 可选优惠券列表 */
	private List<OrgCouponRecord> listCouponRecord;
	
	/** 选择的优惠券 */
	private OrgCouponRecord couponRecordSelect;
	
	/** 选中的物品 */
	private List<OrgCartAll> listCartAll;
	
	/** 送货选项 */
	private OrgOrderSend orgOrderSend;
	
	/** 订单不包含优惠券金额 */
	private BigDecimal orderMoneyNoCoupon;
	
	/** 是否可以自提 */
	private Boolean canTake;
	
	/** 当前预存款余额 */
    private OrgAccountDepositVo accountDeposit;
    
    /** 是否使用预存款余额 */
    private Boolean useDeposit = false;
    
    /** 预存款密码 */
    private String depositPassword;
    
	/** 满减满送 */
    Map<Integer, OrgReach> mapReach;
	
	public Collection<Integer> getGoodsIds() {
		return goodsIds;
	}

	public void setGoodsIds(Collection<Integer> goodsIds) {
		this.goodsIds = goodsIds;
	}

	public Integer getCouponRecordId() {
		return couponRecordId;
	}

	public void setCouponRecordId(Integer couponRecordId) {
		this.couponRecordId = couponRecordId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Boolean getTakeInvoice() {
		return takeInvoice;
	}

	public void setTakeInvoice(Boolean takeInvoice) {
		this.takeInvoice = takeInvoice;
	}

	public List<OrgCouponRecord> getListCouponRecord() {
		return listCouponRecord;
	}

	public void setListCouponRecord(List<OrgCouponRecord> listCouponRecord) {
		this.listCouponRecord = listCouponRecord;
	}

	public List<OrgCartAll> getListCartAll() {
		return listCartAll;
	}

	public void setListCartAll(List<OrgCartAll> listCartAll) {
		this.listCartAll = listCartAll;
	}

	public OrgOrderSend getOrgOrderSend() {
		return orgOrderSend;
	}

	public void setOrgOrderSend(OrgOrderSend orgOrderSend) {
		this.orgOrderSend = orgOrderSend;
	}

	public BigDecimal getOrderMoneyNoCoupon() {
		return orderMoneyNoCoupon;
	}

	public void setOrderMoneyNoCoupon(BigDecimal orderMoneyNoCoupon) {
		this.orderMoneyNoCoupon = orderMoneyNoCoupon;
	}

	public OrgCouponRecord getCouponRecordSelect() {
		return couponRecordSelect;
	}

	public void setCouponRecordSelect(OrgCouponRecord couponRecordSelect) {
		this.couponRecordSelect = couponRecordSelect;
	}

	public Boolean getCanTake() {
		return canTake;
	}

	public void setCanTake(Boolean canTake) {
		this.canTake = canTake;
	}

	public OrgAccountDepositVo getAccountDeposit() {
		return accountDeposit;
	}

	public void setAccountDeposit(OrgAccountDepositVo accountDeposit) {
		this.accountDeposit = accountDeposit;
	}

	public Boolean getUseDeposit() {
		return useDeposit;
	}

	public void setUseDeposit(Boolean useDeposit) {
		this.useDeposit = useDeposit;
	}

	public String getDepositPassword() {
		return depositPassword;
	}

	public void setDepositPassword(String depositPassword) {
		this.depositPassword = depositPassword;
	}

	public Map<Integer, OrgReach> getMapReach() {
		return mapReach;
	}

	public void setMapReach(Map<Integer, OrgReach> mapReach) {
		this.mapReach = mapReach;
	}
	
}
