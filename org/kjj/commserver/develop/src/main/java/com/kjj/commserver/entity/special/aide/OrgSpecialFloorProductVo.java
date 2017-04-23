package com.kjj.commserver.entity.special.aide;

import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAll;
import com.kjj.commserver.entity.special.OrgSpecialFloorProduct;
import com.kjj.commserver.util.ImageUtil;

public class OrgSpecialFloorProductVo extends OrgSpecialFloorProduct {

	// sku表
	private OrgProductItem productItem;

	private OrgProductItemAll orgProductItemAll;

	public OrgProductItem getProductItem() {
		return productItem;
	}

	public OrgProductItemAll getOrgProductItemAll() {
		return orgProductItemAll;
	}

	public void setOrgProductItemAll(OrgProductItemAll orgProductItemAll) {
		this.orgProductItemAll = orgProductItemAll;
	}

	public void setProductItem(OrgProductItem productItem) {
		this.productItem = productItem;
	}

	public void setImagePath(String imagePath) {
		super.setImagePath(ImageUtil.setReadPath(imagePath));
	}

}