package com.kjj.commserver.entity.leveldiscount.aide;

import com.kjj.commserver.entity.leveldiscount.OrgUserLevelProduct;

public class OrgUserLevelProductQuery extends OrgUserLevelProduct {
	
	/** 商品的唯一货号 */
    private String goodsSn;

    /** 商品的名称  */
    private String goodsName;
    
    /* 商品是否删除*/
    private Byte isDelete;
    
	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}

	public String getGoodsSn() {
		return goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
    
}