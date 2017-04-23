package com.kjj.commserver.entity.discount.aide;

import java.util.Collection;
import java.util.List;

import com.kjj.commserver.entity.discount.OrgReach;

/**
 * @Title: OrgReachForm.java
 * @Package com.kjj.commserver.entity.discount.aide
 * @Description: 
 * @author ZYLORG
 * @date 2016年6月8日 下午4:16:58
 * @copyright Beijing KJJ Electronic commerce Co., LTD
 * @version V1.0   
 */
public class OrgReachForm extends OrgReach {
	/** 优惠类型 */
	private Byte typeId = OrgDiscountTypeConstant.TYPE_REACH_DISCOUNT;
	
	/** 适用商品分类 */
	private Collection<Integer> listClass;
	
	/** 适用商品类型 */
	private Collection<Integer> listGoods;
	
	/** 适用终端范围 */
	private Collection<Byte> listScope;
	
	/** 适用城市范围 */
	private Collection<String> listCity;
	
	/** 适用店铺范围 */
	private Collection<Integer> listShop;
	
	/** 适用优惠类型 */
	private List<Byte> listAllow;

	public Collection<Integer> getListClass() {
		return listClass;
	}

	public void setListClass(Collection<Integer> listClass) {
		this.listClass = listClass;
	}

	public Collection<Integer> getListGoods() {
		return listGoods;
	}

	public void setListGoods(Collection<Integer> listGoods) {
		this.listGoods = listGoods;
	}

	public Collection<Byte> getListScope() {
		return listScope;
	}

	public void setListScope(Collection<Byte> listScope) {
		this.listScope = listScope;
	}

	public Collection<String> getListCity() {
		return listCity;
	}

	public void setListCity(Collection<String> listCity) {
		this.listCity = listCity;
	}

	public Collection<Integer> getListShop() {
		return listShop;
	}

	public void setListShop(Collection<Integer> listShop) {
		this.listShop = listShop;
	}

	public Byte getTypeId() {
		return typeId;
	}

	public List<Byte> getListAllow() {
		return listAllow;
	}

	public void setListAllow(List<Byte> listAllow) {
		this.listAllow = listAllow;
	}
}

