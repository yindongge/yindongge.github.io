package com.kjj.commserver.service.leveldiscount;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kjj.commserver.entity.leveldiscount.OrgUserLevelProduct;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelProductQuery;
import com.kjj.commserver.entity.leveldiscount.aide.OrgUserLevelProductVo;
import com.kjj.core.service.BaseService;

public interface OrgUserLevelProductService extends BaseService<OrgUserLevelProduct, Integer> {

	/**
	 * 无条件下查询一体化价格
	 * @param query
	 * @param pageable
	 * @return
	 */
	Page<OrgUserLevelProductVo> selectPageLevelProduct(OrgUserLevelProductQuery query,Pageable pageable);
	
	

	/**
	 * 有条件下查询一体化价格
	 * @param query
	 * @param pageable
	 * @return
	 */
	Page<OrgUserLevelProductVo> selectPageProductLevel(OrgUserLevelProductQuery query, Pageable pageable);
	
	
	/**
	 * 更新一体化价格-生效
	 * @param goodsId
	 * @return
	 */
	void updateActive(Integer goodsId);
	
	/**
	 * 更新一体化价格-无效
	 * @param goodsId
	 * @return
	 */
	void updateNoActive(Integer id);
	
}