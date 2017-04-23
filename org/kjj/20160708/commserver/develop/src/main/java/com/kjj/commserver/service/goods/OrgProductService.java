package com.kjj.commserver.service.goods;

import java.util.List;

import com.kjj.commserver.entity.goods.OrgProduct;
import com.kjj.commserver.entity.goods.OrgProductItem;
import com.kjj.commserver.entity.goods.OrgProductProperty;
import com.kjj.commserver.entity.goods.OrgProductType;
import com.kjj.core.service.BaseService;

public interface OrgProductService extends BaseService<OrgProduct, Integer> {
	/**
	 * 添加商品
	 * @param product
	 */
	void addProductForm(OrgProduct product);
	/**
	 * 获取spu下sku列表（包含关联销售规格及商品属性）
	 * @param parentGoodsId spuId
	 * @return
	 */
	List<OrgProductItem> queryProductItemsByParentId(Integer parentGoodsId);
	/**
	 * 查询sku（包含关联销售规格及商品属性）
	 * @param goodsId skuId
	 * @return
	 */
	OrgProductItem queryProductItemById(Integer goodsId);
	
	/**
	 * 修改sku（包含关联属性，商品图片）
	 * @param productItem
	 */
	void updateSku(OrgProductItem productItem);
	
	/**
	 * 获取商品属性（判断选中状态）
	 * @param skuId skuId
	 * @return
	 */
	List<OrgProductProperty> queryProductPropertyBySkuId(Integer skuId);
	
	/**
	 * 获取商品类型，包含销售规格及商品属性；判断spu销售规格选中状态，并给销售规格字典覆盖自定义属性值；判断spu商品属性选中状态
	 * @param spuId
	 * @return
	 */
	OrgProductType queryProductTypeBySpuId(Integer spuId);
	
	/**
	 * 获取sku（包含已关联销售规格）
	 * @param spuId
	 * @return
	 */
	List<OrgProductItem> queryProductItemBySpuId(Integer spuId);
	/**
	 * 修改spu（包含销售规格、属性、图片及sku）
	 * @param product
	 */
	void updateProductForm(OrgProduct product);
	
	/**
	 * 手动下架
	 * @param spuId
	 */
	void updateOffSale(Integer spuId);
	
	/**
	 * 上架
	 * @param spuId
	 */
	void updateOnSale(Integer spuId);
	
	/**
	 * 逻辑删除spu及其sku
	 * @param spuId
	 */
	void deleteSpuAndSku(Integer spuId);
	
	/**
	 * 批量手动下架
	 * @param spuIds
	 */
	void updateOffSaleInBatch(List<Integer> spuIds);
	
	/**
	 * 批量手动上架
	 * @param spuIds
	 */
	void updateOnSaleInBatch(List<Integer> spuIds);
	
	/**
	 * 批量逻辑删除spu及sku
	 * @param spuIds
	 */
	void deleteSpuAndSkuInBatch(List<Integer> spuIds);
	
	/**
	 * 添加交易快照：生成交易快照主表，商品属性子表。更新交易快照id到sku表org_product_item字段 last_trade_snapshoot_id
	 * @param skuId
	 */
	void addTradeSnapshoot(Integer skuId);
}