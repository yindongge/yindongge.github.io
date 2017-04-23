package com.kjj.commserver.entity.goods.aide;

import java.util.ArrayList;
import java.util.List;

import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.OrgProductLinkProperty;

public class OrgProductItemForm extends OrgProductItem{
	
	/**商品图片*/
	private List<String> goodsImgs;
	
	private List<OrgProductLinkProperty> productLinkPropertyList = new ArrayList<OrgProductLinkProperty>();

	public List<String> getGoodsImgs() {
		return goodsImgs;
	}

	public void setGoodsImgs(List<String> goodsImgs) {
		this.goodsImgs = goodsImgs;
	}

	public List<OrgProductLinkProperty> getProductLinkPropertyList() {
		return productLinkPropertyList;
	}

	public void setProductLinkPropertyList(
			List<OrgProductLinkProperty> productLinkPropertyList) {
		this.productLinkPropertyList = productLinkPropertyList;
	}
	
	

}
