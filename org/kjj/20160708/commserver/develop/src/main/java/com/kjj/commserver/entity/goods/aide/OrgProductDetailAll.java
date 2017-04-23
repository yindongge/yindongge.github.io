package com.kjj.commserver.entity.goods.aide;

import java.util.List;

import com.kjj.commserver.entity.goods.OrgProductImg;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.OrgProductLinkProperty;

public class OrgProductDetailAll {
	/** SKU商品信息 */
	private OrgProductItem orgProductItem;
	
	/** SPU商品信息 */
	private List<OrgProductItem> orgProductItems;
	
	/** SPU商品详情信息 */
	private List<OrgProductLinkProperty> orgProductLinkPropertyList;
	
	/** SPU商品详情信息json */
	private String itemJson;
	
	/** 商品示例图列表 */
	private List<OrgProductImg> orgProductImgList;
	
	public OrgProductItem getOrgProductItem() {
		return orgProductItem;
	}

	public void setOrgProductItem(OrgProductItem orgProductItem) {
		this.orgProductItem = orgProductItem;
	}

	public List<OrgProductItem> getOrgProductItems() {
		return orgProductItems;
	}

	public void setOrgProductItems(List<OrgProductItem> orgProductItems) {
		this.orgProductItems = orgProductItems;
	}

	public List<OrgProductLinkProperty> getOrgProductLinkPropertyList() {
		return orgProductLinkPropertyList;
	}

	public void setOrgProductLinkPropertyList(
			List<OrgProductLinkProperty> orgProductLinkPropertyList) {
		this.orgProductLinkPropertyList = orgProductLinkPropertyList;
	}

	public String getItemJson() {
		return itemJson;
	}

	public void setItemJson(String itemJson) {
		this.itemJson = itemJson;
	}

	public List<OrgProductImg> getOrgProductImgList() {
		return orgProductImgList;
	}

	public void setOrgProductImgList(List<OrgProductImg> orgProductImgList) {
		this.orgProductImgList = orgProductImgList;
	}
}
