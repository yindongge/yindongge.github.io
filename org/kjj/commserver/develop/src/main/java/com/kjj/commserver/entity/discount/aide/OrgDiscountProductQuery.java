package com.kjj.commserver.entity.discount.aide;

import com.kjj.commserver.entity.discount.OrgDiscountProduct;

public class OrgDiscountProductQuery extends OrgDiscountProduct {

	/** 是否删除除商品之外的类型*/
    private Boolean typeProduct = false;

	public Boolean getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(Boolean typeProduct) {
		this.typeProduct = typeProduct;
	}
}