package com.kjj.commserver.entity.goods.aide;

import com.kjj.commserver.entity.goods.OrgProductImg;

public class OrgProductImgQuery extends OrgProductImg {
	/**查询相册标志*/
	private Boolean isAlbumQuery = false;

	public Boolean getIsAlbumQuery() {
		return isAlbumQuery;
	}

	public void setIsAlbumQuery(Boolean isAlbumQuery) {
		this.isAlbumQuery = isAlbumQuery;
	}
	
	
}