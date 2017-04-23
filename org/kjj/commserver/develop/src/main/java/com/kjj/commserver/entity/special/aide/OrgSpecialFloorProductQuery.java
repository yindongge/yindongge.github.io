package com.kjj.commserver.entity.special.aide;

import com.kjj.commserver.entity.special.OrgSpecialFloorProduct;

public class OrgSpecialFloorProductQuery extends OrgSpecialFloorProduct {
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
    
    
}