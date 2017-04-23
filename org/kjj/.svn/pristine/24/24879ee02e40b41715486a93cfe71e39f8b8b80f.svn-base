package com.kjj.commserver.entity.special.aide;

import java.util.ArrayList;
import java.util.List;

import com.kjj.commserver.entity.special.OrgSpecialFloor;
import com.kjj.commserver.entity.special.OrgSpecialFloorProduct;
import com.kjj.commserver.util.ImageUtil;

public class OrgSpecialFloorVo extends OrgSpecialFloor {
	
	/** 楼层下的商品 */
	private List<OrgSpecialFloorProduct> productList = new ArrayList<OrgSpecialFloorProduct>();

	public List<OrgSpecialFloorProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<OrgSpecialFloorProduct> productList) {
		this.productList = productList;
	}
	
	
	@Override
	public void setImgPath(String imgPath) {
		super.setImgPath(ImageUtil.setReadPath(imgPath));
	}
}