package com.kjj.commserver.entity.shop.aide;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.shop.OrgShopPageFloor;

public class OrgShopPageFloorVo extends OrgShopPageFloor {
	
	/** 普通商品 */
    private List<OrgShopPageFloorProductVo> productList;

	/** 推荐商品  */
    private List<OrgShopPageFloorProductVo> recommandList;

	public List<OrgShopPageFloorProductVo> getProductList() {
		return productList;
	}

	public void setProductList(List<OrgShopPageFloorProductVo> productList) {
		this.productList = productList;
	}

	public List<OrgShopPageFloorProductVo> getRecommandList() {
		return recommandList;
	}

	public void setRecommandList(List<OrgShopPageFloorProductVo> recommandList) {
		this.recommandList = recommandList;
	}

	@Override
    public void setPage1(String page1) {
		super.setPage1(StringUtils.isBlank(page1) ? null : ImageConstant.IMAGE_BASE_URL + page1);
    }
}