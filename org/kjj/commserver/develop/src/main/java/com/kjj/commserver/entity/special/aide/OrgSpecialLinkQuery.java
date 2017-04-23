package com.kjj.commserver.entity.special.aide;

import com.kjj.commserver.entity.special.OrgSpecialLink;

public class OrgSpecialLinkQuery extends OrgSpecialLink {
	/** 非锚点,图片链接和商品链接 */
	private Boolean noAnchor;

	public Boolean getNoAnchor() {
		return noAnchor;
	}

	public void setNoAnchor(Boolean noAnchor) {
		this.noAnchor = noAnchor;
	}
	
	
}