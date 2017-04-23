package com.kjj.commserver.entity.goods.aide;

import java.util.Collection;

import com.kjj.commserver.entity.goods.OrgProductInventory;

public class OrgProductInventoryQuery extends OrgProductInventory {
	
	/** 选择的商品编码集合 */
	private Collection<String> goodsSns;
	
	/** 分类*/
	private Integer classId;
	
	/** 商品名称(菜品名称)*/
	private String goodsName;
	
	/** 该商品是否开放销售，1，是；0，否  */
    private Byte isOnSale;
    
    /** 商品是否已经删除，0，否；1，已删除 */
    private Byte isDelete;
	
	public Byte getIsOnSale() {
		return isOnSale;
	}

	public void setIsOnSale(Byte isOnSale) {
		this.isOnSale = isOnSale;
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSorting() {
		return sorting;
	}

	public void setSorting(String sorting) {
		this.sorting = sorting;
	}

	private String sorting;

	public Collection<String> getGoodsSns() {
		return goodsSns;
	}

	public void setGoodsSns(Collection<String> goodsSns) {
		this.goodsSns = goodsSns;
	}

}