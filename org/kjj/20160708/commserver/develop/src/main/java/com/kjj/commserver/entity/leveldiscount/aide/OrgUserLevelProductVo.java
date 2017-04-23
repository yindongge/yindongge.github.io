package com.kjj.commserver.entity.leveldiscount.aide;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.entity.leveldiscount.OrgUserLevelProduct;

public class OrgUserLevelProductVo extends OrgUserLevelProduct {
	/** 商品的唯一货号 */
    private String goodsSn;

    /** 商品的名称  */
    private String goodsName;
    
    /** 商品在前台显示的微缩图片，如在分类筛选时显示的小图片 */
    private String goodsThumb;
    
    /** 商品压缩图片25x25 */
	private String goodsImg25;
	
	/** 商品压缩图片50x50 */
	private String goodsImg50;
	
	/** 商品压缩图片180x180 */
	private String goodsImg180;
	
	/** 商品压缩图片180x180 */
	private String goodsImg350;

	public String getGoodsSn() {
		return goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsThumb() {
		return goodsThumb;
	}

	public void setGoodsThumb(String goodsThumb) {
		this.goodsThumb = ImageConstant.IMAGE_BASE_URL + goodsThumb;

        setGoodsImg25(this.goodsThumb.replace("_", "_25x25"));
        setGoodsImg50(this.goodsThumb.replace("_", "_50x50"));
        setGoodsImg180(this.goodsThumb.replace("_", "_180x180"));
        setGoodsImg350(this.goodsThumb.replace("_", "_350x350"));
	}

	public String getGoodsImg25() {
		return goodsImg25;
	}

	public void setGoodsImg25(String goodsImg25) {
		this.goodsImg25 = goodsImg25;
	}

	public String getGoodsImg50() {
		return goodsImg50;
	}

	public void setGoodsImg50(String goodsImg50) {
		this.goodsImg50 = goodsImg50;
	}

	public String getGoodsImg180() {
		return goodsImg180;
	}

	public void setGoodsImg180(String goodsImg180) {
		this.goodsImg180 = goodsImg180;
	}

	public String getGoodsImg350() {
		return goodsImg350;
	}

	public void setGoodsImg350(String goodsImg350) {
		this.goodsImg350 = goodsImg350;
	}
	
	
}