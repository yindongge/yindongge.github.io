package com.kjj.commserver.entity.goods.aide;

import com.kjj.commserver.entity.goods.OrgProductLinkSalespec;

public class OrgProductLinkSalespecQuery extends OrgProductLinkSalespec {
	/**spuId*/
	private Integer parentGoodsId;
	/**sku isDelete*/
	private Byte isDelete;
	
	public Integer getParentGoodsId() {
		return parentGoodsId;
	}

	public void setParentGoodsId(Integer parentGoodsId) {
		this.parentGoodsId = parentGoodsId;
	}

	public Byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Byte isDelete) {
		this.isDelete = isDelete;
	}
	
	
}