package com.kjj.commserver.entity.goods.aide;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.kjj.commserver.constant.ImageConstant;
import com.kjj.commserver.constant.UploadConstant;
import com.kjj.commserver.entity.discount.OrgLimitTimeGoods;
import com.kjj.commserver.entity.discount.OrgReachGive;
import com.kjj.commserver.entity.goods.OrgClass;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.OrgProductLinkProperty;
import com.kjj.commserver.entity.goods.OrgProductLinkSalespec;

public class OrgProductItemVo extends OrgProductItem {
	
	/** 分类信息 */
	private OrgClass orgClass;
	
	/** 显示折扣商品 */
	private OrgLimitTimeGoods orgLimitTimeGoods;
	
	/** 商品压缩图片25x25 */
	private String goodsImg25;
	
	/** 商品压缩图片50x50 */
	private String goodsImg50;
	
	/** 商品压缩图片180x180 */
	private String goodsImg180;
	
	/** 商品压缩图片180x180 */
	private String goodsImg350;

	/**  ID*/
	private int odpId;
	
	/** sku商品规格信息*/
	private List<OrgProductLinkSalespec> orgProductItemLinkSalespecList = new ArrayList<OrgProductLinkSalespec>();
	
	/**  商品规格种类*/
	private List<Map<String, Object>> specTypeList; 
	
	/** 产品是否开放销售，1，是；0，否  */
	private Byte productIsOnSale;
	/** 产品是否已经删除，0，否；1，已删除 */
	private Byte productIsDelete;
	
	/** sku商品属性信息*/
	private List<OrgProductLinkProperty> orgProductItemLinkPropertyList;
	
	private String saleSpecStr;
	/**品牌名称*/
	private String productBrandName;
	/**商品推荐ID*/
	private Integer oirId;
	
	/** 购物车商品数量 */
	private Integer amount;
	
	/** 满减赠送商品 */
	private OrgReachGive orgReachGive;
	
	/** 店铺库存数量 */
	private Integer shopAmount;
	
	/** 赠送数量 */
	private Integer giveAmount;
	
	/** 模块id */
	private Integer moduleId;
	
	private Integer moduleGoodsId;
	
	public OrgClass getOrgClass() {
		return orgClass;
	}

	public void setOrgClass(OrgClass orgClass) {
		this.orgClass = orgClass;
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

	public int getOdpId() {
		return odpId;
	}

	public void setOdpId(int odpId) {
		this.odpId = odpId;
	}

	public OrgLimitTimeGoods getOrgLimitTimeGoods() {
		return orgLimitTimeGoods;
	}

	public void setOrgLimitTimeGoods(OrgLimitTimeGoods orgLimitTimeGoods) {
		this.orgLimitTimeGoods = orgLimitTimeGoods;
	}

	@Override
	public void setGoodsThumb(String goodsThumb) {
		if(StringUtils.isNotEmpty(goodsThumb)){
			if(!goodsThumb.contains(ImageConstant.IMAGE_BASE_URL)){
				goodsThumb = ImageConstant.IMAGE_BASE_URL + goodsThumb;			
			}
			//原尺寸
			super.setGoodsImg(goodsThumb);
			setGoodsImg25(goodsThumb.replace("_", "_25x25"));
			setGoodsImg50(goodsThumb.replace("_", "_50x50"));
			setGoodsImg180(goodsThumb.replace("_", "_180x180"));
			setGoodsImg350(goodsThumb.replace("_", "_350x350"));
		}
        super.setGoodsThumb(goodsThumb);
    }

	public List<OrgProductLinkSalespec> getOrgProductItemLinkSalespecList() {
		return orgProductItemLinkSalespecList;
	}

	public void setOrgProductItemLinkSalespecList(
			List<OrgProductLinkSalespec> orgProductItemLinkSalespecList) {
		this.orgProductItemLinkSalespecList = orgProductItemLinkSalespecList;
	}

	public List<Map<String, Object>> getSpecTypeList() {
		return specTypeList;
	}

	public void setSpecTypeList(List<Map<String, Object>> specTypeList) {
		this.specTypeList = specTypeList;
	}

	public Byte getProductIsOnSale() {
		return productIsOnSale;
	}

	public void setProductIsOnSale(Byte productIsOnSale) {
		this.productIsOnSale = productIsOnSale;
		super.setIsOnSale(productIsOnSale);
	}

	public Byte getProductIsDelete() {
		return productIsDelete;
	}

	public void setProductIsDelete(Byte productIsDelete) {
		this.productIsDelete = productIsDelete;
		super.setIsDelete(productIsDelete);
	}

	public List<OrgProductLinkProperty> getOrgProductItemLinkPropertyList() {
		return orgProductItemLinkPropertyList;
	}

	public void setOrgProductItemLinkPropertyList(
			List<OrgProductLinkProperty> orgProductItemLinkPropertyList) {
		this.orgProductItemLinkPropertyList = orgProductItemLinkPropertyList;
	}

	public String getSaleSpecStr() {
		return saleSpecStr;
	}

	public void setSaleSpecStr(String saleSpecStr) {
		this.saleSpecStr = saleSpecStr;
	}

	public String getProductBrandName() {
		return productBrandName;
	}

	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
	}

	@Override
	public void setGoodsDesc(String goodsDesc) {
		if(StringUtils.isNotEmpty(goodsDesc) && goodsDesc.indexOf(UploadConstant.KINDEDITOR_UPLOAD_BASE_URL)==-1){
//			goodsDesc= goodsDesc.replace("/platform", ImageConstant.IMAGE_OLD_URL+"/platform");
			goodsDesc= goodsDesc.replace("src=\"", "src=\""+UploadConstant.KINDEDITOR_UPLOAD_BASE_URL);
			
		}
		super.setGoodsDesc(goodsDesc);
	}

	@Override
	public void setMobileGoodsDesc(String mobileGoodsDesc) {
		if(StringUtils.isNotEmpty(mobileGoodsDesc) && mobileGoodsDesc.indexOf(UploadConstant.KINDEDITOR_UPLOAD_BASE_URL)==-1){
//			mobileGoodsDesc= mobileGoodsDesc.replace("/platform", ImageConstant.IMAGE_OLD_URL+"/platform");	
			mobileGoodsDesc= mobileGoodsDesc.replace("src=\"", "src=\""+UploadConstant.KINDEDITOR_UPLOAD_BASE_URL);
		}
		super.setMobileGoodsDesc(mobileGoodsDesc);
	}

	public Integer getOirId() {
		return oirId;
	}

	public void setOirId(Integer oirId) {
		this.oirId = oirId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public OrgReachGive getOrgReachGive() {
		return orgReachGive;
	}

	public void setOrgReachGive(OrgReachGive orgReachGive) {
		this.orgReachGive = orgReachGive;
	}

	public Integer getShopAmount() {
		return shopAmount;
	}

	public void setShopAmount(Integer shopAmount) {
		this.shopAmount = shopAmount;
	}

	public Integer getGiveAmount() {
		return giveAmount;
	}

	public void setGiveAmount(Integer giveAmount) {
		this.giveAmount = giveAmount;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getModuleGoodsId() {
		return moduleGoodsId;
	}

	public void setModuleGoodsId(Integer moduleGoodsId) {
		this.moduleGoodsId = moduleGoodsId;
	}
	
	
}